// Last updated: 9/13/2025, 12:36:06 PM
class Solution {
    public int maxFreqSum(String s) {
        int[] alpha = new int[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a']++;
        }
        
        int maxVowel = 0;
        int maxConsonant = 0;
        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                maxVowel = Math.max(maxVowel, alpha[i]);
            } else {
                maxConsonant = Math.max(maxConsonant, alpha[i]);
            }
        }
        return maxVowel+maxConsonant;
    }
}