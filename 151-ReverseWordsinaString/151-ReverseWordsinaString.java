// Last updated: 10/14/2025, 3:25:34 PM
class Solution {
    public String reverseWords(String s) {
        StringBuilder b = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int startIndex = i;
            while (startIndex >= 0 && s.charAt(startIndex) != ' ') {
                startIndex--;
            }

            if(startIndex < i) {
                b.append(" ");
                b.append(s, startIndex + 1, i+1);
            }

            i = startIndex;
        }

        return b.toString().trim();   
    }
}