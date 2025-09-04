// Last updated: 9/4/2025, 10:50:29 AM
// class Solution {
//     public String longestPalindrome(String s) {
//         int centers = 2*s.length() -1;
//         int max = 0;
//         int bestLeft = 0;
//         int bestRight = 0;
//         StringBuilder sb = new StringBuilder(s);
//         StringBuilder ans = new StringBuilder();
//         for(int i=0;i<centers;i++){
//             int left = i/2;
//             int right = left+(i%2);
//             while(left>=0 && right<sb.length() && s.charAt(left) == s.charAt(right)){
//                 if(s.charAt(left) == s.charAt(right)){
//                     bestLeft = left;
//                     bestRight = right;
//                 }
//                 left--;
//                 right++;
//             }
//             if(substring.length() > max){
//                 max = substring.length();
//                 ans = substring;
//             }
//         }   
//         return ans.toString();
//     }
// }

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        int bestL = 0, bestR = 0; // inclusive bounds of the best palindrome
        int centers = 2 * n - 1;

        for (int c = 0; c < centers; c++) {
            int left = c / 2;
            int right = left + (c % 2);

            // expand ONLY while it remains a palindrome
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left > bestR - bestL) {
                    bestL = left;
                    bestR = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(bestL, bestR + 1);
    }
}
