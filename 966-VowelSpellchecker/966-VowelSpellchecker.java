// Last updated: 9/14/2025, 4:44:10 PM
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];
        Arrays.fill(ans, "");
        List<String> wordList = new ArrayList<>(Arrays.asList(wordlist));
        List<String> wordListLower = new ArrayList<>(Arrays.stream(wordlist)
                                              .map(String::toLowerCase)
                                              .toList());
        List<String> wordListFixedVowel = new ArrayList<>();
        Set<Character> vowels = Set.of('a','e','i','o','u');
        for(int i=0;i<wordListLower.size();i++){
            StringBuilder sb = new StringBuilder();
            for (char c : wordListLower.get(i).toCharArray()) {
                if (vowels.contains(c)) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            wordListFixedVowel.add(sb.toString());
        }

        //main loop
        for(int i=0;i<queries.length;i++){
            //exact match
            if(wordList.contains(queries[i])){
                ans[i] = queries[i];
            }

            //lower case match
            else if(wordListLower.contains(queries[i].toLowerCase())){
                ans[i] = wordlist[wordListLower.indexOf(queries[i].toLowerCase())];
            }

            //without vowel match
            else{
                StringBuilder sb = new StringBuilder();
                for (char c : queries[i].toLowerCase().toCharArray()){
                    if (vowels.contains(c)) {
                        sb.append('*');
                    } else {
                        sb.append(c);
                    }
                }
                if(wordListFixedVowel.contains(sb.toString().toLowerCase())){
                    ans[i] = wordlist[wordListFixedVowel.indexOf(sb.toString().toLowerCase())];
                }
            }
        }

        return ans;
        
    }
}