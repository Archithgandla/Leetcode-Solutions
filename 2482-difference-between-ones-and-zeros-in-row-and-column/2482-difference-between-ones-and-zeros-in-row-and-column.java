class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        
        
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        int[][] ans = new int[grid.length][grid[0].length];
        
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    rows[i]+=1;
                    cols[j]+=1;
                }
            }            
        }
        
        
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                ans[i][j] = rows[i]+cols[j]-(grid.length-rows[i])-(grid[0].length-cols[j]);
            }
        }
        
        return ans;
        
    }
}




