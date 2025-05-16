/*A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, "", 0, result);
        return result;
    }

    private void backtrack(String s, int index, String currentIP, int segmentCount, List<String> result) {
        if (segmentCount == 4 && index == s.length()) {
            result.add(currentIP.substring(0, currentIP.length() - 1));
            return;
        }

        if (segmentCount >= 4 || index >= s.length()) {
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String segment = s.substring(index, index + len);

            if (isValidSegment(segment)) {
                backtrack(s, index + len, currentIP + segment + ".", segmentCount + 1, result);
            }
        }
    }

    private boolean isValidSegment(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) {
            return false;
        }

        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}