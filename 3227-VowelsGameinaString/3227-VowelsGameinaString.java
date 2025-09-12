// Last updated: 9/12/2025, 7:38:30 AM
class Solution {
    public boolean doesAliceWin(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        if(count == 0) return false;
        else if(count%2 == 1) return true;
        else return true;
    }
}