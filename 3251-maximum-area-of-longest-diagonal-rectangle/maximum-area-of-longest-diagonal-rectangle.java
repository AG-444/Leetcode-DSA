class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double Max = 0.0;
        int idx = -1;
        for(int i=0;i<dimensions.length;i++){
            double curr = Math.sqrt((dimensions[i][0]*dimensions[i][0])+(dimensions[i][1]*dimensions[i][1]));
            if(curr>Max){
                Max = curr;
                idx = i;
            }
            else if(curr==Max){
                if(dimensions[idx][0]*dimensions[idx][1] < dimensions[i][0]*dimensions[i][1]){
                    Max = curr;
                    idx = i;
                }
            } 
            System.out.println(i+" - "+dimensions[i][0]+" - "+dimensions[i][1]+" - "+ curr+ " - "+Max);
             
        }
        System.out.println(dimensions[idx][0]+" - "+dimensions[idx][1]);
        return dimensions[idx][0]*dimensions[idx][1];
    }
}