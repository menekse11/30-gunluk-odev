/*You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].

For each queries[i]:

Select a subset of indices within the range [li, ri] in nums.
Decrement the values at the selected indices by 1.
A Zero Array is an array where all elements are equal to 0.

Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.*/
class Solution {
    public boolean canTransform(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            diff[q[0]] += 1;
            if (q[1] + 1 < n) diff[q[1] + 1] -= 1;
        }
        int[] decrement = new int[n];
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            decrement[i] = curr;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] < decrement[i]) return false;
        }
        for (int i = 0; i < n; i++) {
            nums[i] -= decrement[i];
            if (nums[i] != 0) return false;
        }
        return true;
    }
}
