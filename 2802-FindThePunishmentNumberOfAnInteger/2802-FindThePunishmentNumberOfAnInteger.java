// Last updated: 8/28/2025, 9:57:34 AM
class Solution {
    public int punishmentNumber(int n) {
        int total = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canPartition(String.valueOf(square), 0, i)) {
                total += square;
            }
        }

        return total;
    }

    // Recursive backtracking function to check if numStr can be partitioned to sum up to target
    private boolean canPartition(String numStr, int index, int target) {
        if (index == numStr.length()) {
            return target == 0;
        }

        int currentNum = 0;
        for (int i = index; i < numStr.length(); i++) {
            currentNum = currentNum * 10 + (numStr.charAt(i) - '0');
            if (currentNum > target) break;
            if (canPartition(numStr, i + 1, target - currentNum)) {
                return true;
            }
        }

        return false;
    }
}
