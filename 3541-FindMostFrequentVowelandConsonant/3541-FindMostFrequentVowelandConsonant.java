// Last updated: 9/13/2025, 12:34:35 PM
class Solution {
    public int maxFreqSum(String s) {
        int[] alpha = new int[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a']++;
        }
        int maxVowel = Collections.max(Arrays.asList(alpha[0],alpha[4],alpha[8],alpha[14],alpha[20]));
        
        alpha[0]=0;
        alpha[4]=0;
        alpha[8]=0;
        alpha[14]=0;
        alpha[20]=0;

        int max = Arrays.stream(alpha).max().getAsInt();

        return maxVowel+max;
    }
}