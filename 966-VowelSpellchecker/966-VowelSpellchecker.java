// Last updated: 9/14/2025, 6:41:43 PM
class Solution {
    Set<String> set;
    Map<String,String> wordMap;
    Map<String,String> vowMap;
    public String[] spellchecker(String[] wordlist, String[] queries) {
        set = new HashSet<>();
        wordMap = new HashMap<>();
        vowMap = new HashMap<>();
        for(String word:wordlist){
            set.add(word);
            String wordlow = word.toLowerCase();
            wordMap.putIfAbsent(wordlow,word);
            String wordlowDV = devowel(wordlow);
            vowMap.putIfAbsent(wordlowDV,word);
        }
        String ans[] = new String[queries.length];
        int i = 0;
        for(String query:queries){
            ans[i++] = solve(query);
        }
        return ans;
    }
    public String devowel(String word){
        StringBuilder str = new StringBuilder();
        for(char c:word.toCharArray()){
            str.append(isVowel(c)?'*':c);
        }
        return str.toString();
    }
    public boolean isVowel(char c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
    public String solve(String query){
        if(set.contains(query)){
            return query;
        }
        String querylow = query.toLowerCase();
        if(wordMap.containsKey(querylow)){
            return wordMap.get(querylow);
        }
        String querylv = devowel(querylow);
        if(vowMap.containsKey(querylv)){
            return vowMap.get(querylv);
        }
        return "";
    }
}