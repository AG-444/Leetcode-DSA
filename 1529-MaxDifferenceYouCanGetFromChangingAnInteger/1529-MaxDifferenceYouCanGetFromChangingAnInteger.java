// Last updated: 8/28/2025, 9:57:51 AM
class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        
        // Step 1: Maximize the number
        char[] maxArr = s.toCharArray();
        char toReplaceMax = ' ';
        for (char c : maxArr) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        if (toReplaceMax != ' ') {
            for (int i = 0; i < maxArr.length; i++) {
                if (maxArr[i] == toReplaceMax) {
                    maxArr[i] = '9';
                }
            }
        }
        int maxNum = Integer.parseInt(new String(maxArr));
        
        // Step 2: Minimize the number
        char[] minArr = s.toCharArray();
        char toReplaceMin = ' ';
        if (minArr[0] != '1') {
            toReplaceMin = minArr[0];
            for (int i = 0; i < minArr.length; i++) {
                if (minArr[i] == toReplaceMin) {
                    minArr[i] = '1';
                }
            }
        } else {
            for (int i = 1; i < minArr.length; i++) {
                if (minArr[i] != '0' && minArr[i] != '1') {
                    toReplaceMin = minArr[i];
                    for (int j = 0; j < minArr.length; j++) {
                        if (minArr[j] == toReplaceMin) {
                            minArr[j] = '0';
                        }
                    }
                    break;
                }
            }
        }
        int minNum = Integer.parseInt(new String(minArr));
        
        return maxNum - minNum;
    }
}
