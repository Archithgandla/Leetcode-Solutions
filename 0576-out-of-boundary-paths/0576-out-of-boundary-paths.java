class Solution {
    
    
    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};

    public int Util(int m, int n, int maxMove, int startRow, int startColumn,int[][][] dp) {

        if(startRow<0 || startRow>=m || startColumn<0 || startColumn>=n)
            return 1;

        if(maxMove == 0)
            return 0;

        //System.out.println(startRow+" "+startColumn+" "+maxMove);

        if(dp[startRow][startColumn][maxMove] != -1)
            return dp[startRow][startColumn][maxMove];

        long count = 0;

        for(int i=0;i<dr.length;i++)
            count = (count+Util(m,n,maxMove-1,startRow+dr[i],startColumn+dc[i],dp))%(int)(1e9+7);

        return dp[startRow][startColumn][maxMove] = (int)count;

    }


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        int[][][] dp = new int[m][n][maxMove+1];

        for(int[][] temp:dp){
            for(int[] arr:temp)
                Arrays.fill(arr,-1);
        }


        return Util(m,n,maxMove,startRow,startColumn,dp);

    }
}


