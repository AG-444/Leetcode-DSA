// Last updated: 9/11/2025, 10:19:12 AM
class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int n = s.length();
        Character[] t = new Character[n];
        List<Character> chars = new ArrayList<>();
        List<Integer> index = new ArrayList<>();



        for(int i=0;i<n;i++){
            if(vowels.contains(s.charAt(i))){
                chars.add(s.charAt(i));
                index.add(i);
            }
            else{
                t[i] = s.charAt(i);
            }
        }
        Collections.sort(chars);
        for(int i=0;i<chars.size();i++){
            t[index.get(i)] = chars.get(i);
        }

        StringBuilder sb = new StringBuilder();
        for(char ch:t){
            sb.append(ch);
        }

        return sb.toString();
    }
}