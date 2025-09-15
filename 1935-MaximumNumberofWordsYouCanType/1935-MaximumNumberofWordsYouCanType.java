// Last updated: 9/15/2025, 11:04:09 AM
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for(char ch:brokenLetters.toCharArray()){
            broken.add(ch);
        }
        int count = 0;
        String[] arr = text.split(" ");
        for(int i=0;i<arr.length;i++){
            boolean check = true;
            for(char ch:arr[i].toCharArray()){
                if(broken.contains(ch)){
                    check = false;
                    break;
                }
            }
            if(check) count++;
        }
        return count;
    }
}