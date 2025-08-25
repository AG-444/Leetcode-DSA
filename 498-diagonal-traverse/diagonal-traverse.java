class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int high = n+m-2;
        if(n==1) return mat[0];
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<=(high/2);i++){
            System.out.println(i);
            if(i%2==0){
                for(int j=i;j>=0;j--){
                    int k = i-j;
                    if(j<n && k<m && k>=0 && j>=0){ 
                        System.out.println("ADDED - "+j+" - "+k+" = "+mat[j][k]);
                        arr.add(mat[j][k]);
                    }
                }
            }
            else{
                for(int j=0;j<=i;j++){
                    int k = i-j;
                    if(j<n && k<m && k>=0 && j>=0) {
                        System.out.println("ADDED - "+j+" - "+k+" = "+mat[j][k]);
                        arr.add(mat[j][k]);
                    }
                }
            }
        }
        int idx = 0;
        for (int i = (high/2)+1; i <= high; i++) {
            if (i % 2 == 0) {
                int row = Math.min(i, n-1);
                int col = i - row;
                while (row >= 0 && col < m) {
                    arr.add(mat[row][col]);
                    row--;
                    col++;
                }
            } else {
                int col = Math.min(i, m-1);
                int row = i - col;
                while (row < n && col >= 0) {
                    arr.add(mat[row][col]);
                    row++;
                    col--;
                }
            }
        }
        Integer[] boxedArr = arr.toArray(new Integer[0]);
        int[] result = new int[boxedArr.length];
        for (int i = 0; i < boxedArr.length; i++) {
            result[i] = boxedArr[i];  // auto-unboxing
        }
        return result;
    }
}