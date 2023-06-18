class Solution {

    int Util(int[][] grid,int row,int col,int[] dr,int[] dc,int[][] dp){

        //System.out.println(grid[row][col]+" "+prev);

        if(dp[row][col] != -1)
            return dp[row][col];


        int prev = grid[row][col];

        long count = 0;
        for(int i=0;i<dr.length;i++){
            int new_row = row+dr[i];
            int new_col = col+dc[i];

            if(new_row>=0 && new_row<grid.length && new_col>=0 && new_col<grid[0].length
            && grid[new_row][new_col]>prev){
                count = (int)(count+Util(grid,new_row,new_col,dr,dc,dp))%(int)(1e9+7);
            }
        }
        
        return dp[row][col] = (int)(count+1);

    }

    public int countPaths(int[][] grid) {
        
        long ans = 0;

        int[] dr = new int[]{-1,1,0,0};
        int[] dc = new int[]{0,0,-1,1};
        int[][] dp = new int[grid.length][grid[0].length];

        for(int[] arr:dp)
            Arrays.fill(arr,-1);

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                ans = (int)(ans+Util(grid,i,j,dr,dc,dp))%(int)(1e9+7);
                //System.out.println("");
            }
        }

        // long result = 0;
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++)
        //         result = (int)(result + dp[i][j])%(int)(1e9+7);
        // }

        return (int)ans;
    }
}





