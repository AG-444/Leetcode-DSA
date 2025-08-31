// Last updated: 8/31/2025, 10:51:24 AM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check rows
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (!seen.add(c)) return false;
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {
            HashSet<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (!seen.add(c)) return false;
            }
        }

        // Check 3x3 subgrids
        for (int blockRow = 0; blockRow < 3; blockRow++) {
            for (int blockCol = 0; blockCol < 3; blockCol++) {
                HashSet<Character> seen = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = board[blockRow * 3 + i][blockCol * 3 + j];
                        if (c == '.') continue;
                        if (!seen.add(c)) return false;
                    }
                }
            }
        }

        return true;
    }
}
