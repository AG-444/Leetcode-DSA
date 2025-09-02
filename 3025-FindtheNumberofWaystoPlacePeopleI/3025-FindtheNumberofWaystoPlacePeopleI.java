// Last updated: 9/2/2025, 10:01:12 AM
class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0;
        int n = points.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((points[j][0] - points[i][0])<=0 && (points[j][1] - points[i][1])>=0){
                    if(i==j) continue;
                    boolean check = true;
                    // System.out.println("i: " + Arrays.toString(points[i]) + ", j: " + Arrays.toString(points[j]));
                    for(int k=0;k<n;k++){
                        if(k==i||k==j) continue;
                        if(points[k][0]>=points[j][0] && points[k][0]<=points[i][0] && points[k][1]<=points[j][1] && points[k][1]>= points[i][1]){
                            // System.out.println("i: " + Arrays.toString(points[i]) + ", j: " + Arrays.toString(points[j])+ " TEST - "+Arrays.toString(points[k]));
                            check = false;
                            break;
                        }
                    }
                    if(check) count++;
                }
            }
        }
        return count;
    }
}