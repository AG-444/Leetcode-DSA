// Last updated: 9/12/2025, 7:32:19 AM
class Solution {
    public static String justify(int lineLen, List<String> line, int maxWidth){
        int spacesNeeded = maxWidth - lineLen;
        int gaps = line.size() -1;
        int evenSpaces = (int) spacesNeeded/gaps;
        StringBuilder sbFixedSpace = new StringBuilder();
        for(int i=0;i<evenSpaces;i++){
            sbFixedSpace.append(" ");
        }
        int extra = spacesNeeded%gaps;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i));
            if (i < line.size() - 1) { // only between words
                sb.append(sbFixedSpace);
                if (extra > 0) {
                    sb.append(" ");
                    extra--;
                }
            }
        }

        return sb.toString();
    }

    public static String leftJustify(List<String> line, int lineLen, int maxWidth){
        int spacesNeeded = maxWidth - lineLen - (line.size() - 1);
        StringBuilder space = new StringBuilder();
        for(int i=0;i<spacesNeeded;i++){
            space.append(" ");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.size(); i++) {
            sb.append(line.get(i));
            if (i < line.size() - 1) {
                sb.append(" ");
            }
        }

        sb.append(space);
        return sb.toString();
    }
    public List<String> fullJustify(String[] words, int maxWidth){

        List<List<String>> lines = new ArrayList<>();
        List<String> currLine = new ArrayList<>(); 
        int currLen = 0;
        List<String> ans = new ArrayList<>();
        
        
        for(int i=0;i<words.length;i++){
            if(currLen + words[i].length() + currLine.size()  <= maxWidth){
                currLen += words[i].length();
                currLine.add(words[i]);
            }
            else{
                lines.add(new ArrayList<>(currLine));
                currLine.clear();
                currLine.add(words[i]);
                currLen = words[i].length();
            }
        }

        if (!currLine.isEmpty()) lines.add(new ArrayList<>(currLine));

        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int lineLen = 0;
            for (String w : line) lineLen += w.length();

            if (i == lines.size() - 1 || line.size() == 1) {
                ans.add(leftJustify(line, lineLen, maxWidth));
            } else {
                ans.add(justify(lineLen, line, maxWidth));
            }
        }


        return ans;
    }
}