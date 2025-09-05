// Last updated: 9/5/2025, 8:24:23 PM
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits.length() == 0) {
            return results;
        }
        
        Map<Character, char[]> digitToLetters = new HashMap<>(8);
        digitToLetters.put('2', new char[]{ 'a', 'b', 'c' });
        digitToLetters.put('3', new char[]{ 'd', 'e', 'f' });
        digitToLetters.put('4', new char[]{ 'g', 'h', 'i' });
        digitToLetters.put('5', new char[]{ 'j', 'k', 'l' });
        digitToLetters.put('6', new char[]{ 'm', 'n', 'o' });
        digitToLetters.put('7', new char[]{ 'p', 'q', 'r', 's' });
        digitToLetters.put('8', new char[]{ 't', 'u', 'v' });
        digitToLetters.put('9', new char[]{ 'w', 'x', 'y', 'z' });

        buildLetterCombinations(digits, 0, digitToLetters, new StringBuilder(digits.length()), results);

        return results;
    }

    private void buildLetterCombinations(String digits, int digitIndex, Map<Character, char[]> digitToLetters, StringBuilder builder, List<String> results) {
        if (digitIndex >= digits.length()) {
            results.add(builder.toString());
            return;
        }

        char digit = digits.charAt(digitIndex);
        for (char letter : digitToLetters.get(digit)) {
            builder.append(letter);
            buildLetterCombinations(digits, digitIndex + 1, digitToLetters, builder, results);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}