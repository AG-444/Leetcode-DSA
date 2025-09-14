// Last updated: 9/14/2025, 11:56:46 AM
class Solution {
    public int repeatedStringMatch(String a, String b) {
            for (char c : b.toCharArray()) {
                if (a.indexOf(c) == -1) return -1;
            }

            int min = (int)Math.ceil((double)b.length() / a.length());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < min; i++) sb.append(a);

            if (kmpContains(sb.toString(), b)) return min;
            if (kmpContains(sb.append(a).toString(), b)) return min + 1;
            return -1;
    }

    private boolean kmpContains(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        int[] lps = buildLPS(pattern);

        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (j == m) return true; // found match
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0, i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }

}