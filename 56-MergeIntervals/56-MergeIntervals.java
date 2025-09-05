// Last updated: 9/5/2025, 9:12:10 PM
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
            if(!ans.isEmpty() && end<=ans.get(ans.size()-1)[1]) continue;
            for(int j=i+1;j<n;j++){
                if (arr[j][0]<=end){
                    end = Math.max(end, arr[j][1]);
                }
                else{
                    break;
                }
            }

            ans.add(new int[]{start,end});
        }
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i); // each element is already an int[2]
        }
        return result;
    }
}