// Last updated: 9/5/2025, 9:20:48 PM
class Solution {
    public int[][] merge(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr, (a,b) -> {
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int start = arr[i][0];
            int end = arr[i][1];
            if(ans.isEmpty()) ans.add(new int[]{start,end});
            else{
                int prevEnd = ans.get(ans.size()-1)[1];
                if(prevEnd >= start){
                    prevEnd = Math.max(prevEnd,end);
                    ans.get(ans.size()-1)[1] = prevEnd;
                }
                else{
                    ans.add(new int[]{start,end});
                }
            }
        }
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}