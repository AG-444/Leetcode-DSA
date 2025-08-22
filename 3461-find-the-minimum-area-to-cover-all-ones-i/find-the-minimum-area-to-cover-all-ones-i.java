class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int minI = Integer.MAX_VALUE;
        int maxI = Integer.MIN_VALUE;

        int minJ = Integer.MAX_VALUE;
        int maxJ = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    if(i<minI){
                        minI = i;
                    }
                    if(i>maxI){
                        maxI = i;
                    }
                    if(j>maxJ){
                        maxJ = j;
                    }
                    if(j<minJ){
                        minJ = j;
                    }
                }
            }
        }
        return (maxI-minI+1)*(maxJ-minJ+1);
    }
}