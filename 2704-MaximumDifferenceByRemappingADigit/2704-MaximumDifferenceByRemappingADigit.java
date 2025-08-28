// Last updated: 8/28/2025, 9:57:36 AM
class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int maxVal = num;
        int minVal = num;

        // Try remapping each digit (0-9) to 9 for max
        for (char d = '0'; d <= '9'; d++) {
            String replaced = s.replace(d, '9');
            maxVal = Math.max(maxVal, Integer.parseInt(replaced));
        }

        // Try remapping each digit (0-9) to 0 for min
        for (char d = '0'; d <= '9'; d++) {
            String replaced = s.replace(d, '0');
            minVal = Math.min(minVal, Integer.parseInt(replaced));
        }

        return maxVal - minVal;
    }
}
