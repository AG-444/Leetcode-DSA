import java.util.ArrayList;

class Solution {
    public int[][] sortMatrix(int[][] grid){
        int n = grid.length;
        int[][] ans = new int[n][n];
        List<List<Integer>> bottomLeft = new ArrayList<>();
        List<List<Integer>> topRight = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> curr = new ArrayList<>();
            bottomLeft.add(curr);
        }
        for(int i=0;i<n-1;i++){
            List<Integer> curr = new ArrayList<>();
            topRight.add(curr);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                bottomLeft.get(i-j).add(grid[i][j]);
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                topRight.get(j-i-1).add(grid[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            bottomLeft.get(i).sort((a,b) -> b.compareTo(a));
        }
        for(int i=0;i<n-1;i++){
            topRight.get(i).sort((a,b) -> a.compareTo(b));
        }

        

        System.out.println(bottomLeft);
        System.out.println(topRight);
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                ans[i][j] = topRight.get(j-i-1).get(i);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                ans[i][j] = bottomLeft.get(i-j).get(j);
            }
        }


        return ans;
    }
}