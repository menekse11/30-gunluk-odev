
/*There is a dungeon with n x m rooms arranged as a grid.

You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.

Return the minimum time to reach the room (n - 1, m - 1).

Two rooms are adjacent if they share a common wall, either horizontally or vertically.

 

Example 1:

Input: moveTime = [[0,4],[4,4]]

Output: 7

Explanation:

The minimum time required is 7 seconds.

At time t == 4, move from room (0, 0) to room (1, 0) in one second.
At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.
*/
class Solution {
    static class State {
        int x, y, time, step;
        State(int x, int y, int time, int step) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.step = step;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        boolean[][][] visited = new boolean[n][m][2];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0, 0));

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.x == n - 1 && cur.y == m - 1) return cur.time;

            int moveCost = (cur.step % 2 == 0) ? 1 : 2;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int arrivalTime = cur.time + moveCost;
                    if (arrivalTime < moveTime[nx][ny]) {
                        arrivalTime = moveTime[nx][ny];
                    }
                    int nextStep = cur.step + 1;
                    if (!visited[nx][ny][nextStep % 2]) {
                        visited[nx][ny][nextStep % 2] = true;
                        queue.add(new State(nx, ny, arrivalTime, nextStep));
                    }
                }
            }
        }

        return -1;
    }
}