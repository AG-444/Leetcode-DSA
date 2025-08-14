class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        ArrayList<String> substr = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            substr.add(num.substring(i,i+3));
           
        }
        for(int i=substr.size()-1;i>=0;i--){
            String curr = substr.get(i);
            if (curr.charAt(0) == curr.charAt(1) && curr.charAt(1) == curr.charAt(2)){
                continue;
            }
            else{
                substr.remove(curr);
            }
        }
        int maxInd = -1;
        int max = -99999;
        for(int i=0;i<substr.size();i++){
            char ch = substr.get(i).charAt(0);
            int x = ch - '0';
            if(x > max){
                System.out.println(substr.get(i));
                max = x;
                maxInd = i;
            }
        }
        if (maxInd == -1){
            return "";
        }
        return substr.get(maxInd);
    }
}