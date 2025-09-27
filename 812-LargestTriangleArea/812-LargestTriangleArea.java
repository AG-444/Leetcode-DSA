// Last updated: 9/27/2025, 2:23:17 PM
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0;

        for(int i=0;i<n;i++){
            double x1 = points[i][0], y1 = points[i][1];
            for(int j=0;j<n;j++){
                double x2 = points[j][0], y2 = points[j][1];
                for(int k=0;k<n;k++){
                    double x3 = points[k][0], y3 = points[k][1];
                    maxArea = Math.max(maxArea , 0.5*(Math.abs(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2))));
                }
            }
        }

        return maxArea;

    }
}