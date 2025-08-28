// Last updated: 8/28/2025, 9:58:57 AM
class Solution {
    public String intToRoman(int num) {
        // Arrays of Roman numerals and their corresponding integer values
        int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40, 10, 9,   5, 4,  1};
        String[] symbols ={"M",  "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        // Iterate through each symbol-value pair
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }
}
