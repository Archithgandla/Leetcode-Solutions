class Solution {
   

   //Memoization
    public long Util(int[][] points,int row,int col,long[][] dp){

        if(row == points.length)
            return 0;
        if(dp[row][col] != -1)
            return dp[row][col];
        if(row == points.length-1)
            return points[row][col];

        long ans = 0;

        for(int j=0;j<points[0].length;j++)
            ans = Math.max(ans,Util(points,row+1,j,dp)-Math.abs(j-col));
        
        return dp[row][col] = (ans+points[row][col]);

    }
    
    public long maxPoints(int[][] points) {
        
        long ans = 0;
        long[][] dp = new long[points.length][points[0].length];

        // for(long[] temp:dp)
        //     Arrays.fill(temp,-1);

        // for(int j=0;j<points[0].length;j++){
        //     ans = Math.max(ans,Util(points,0,j,dp));
        // }

        for(int j=0;j<points[0].length;j++)
            dp[points.length-1][j] = points[points.length-1][j] ;



        //Tabulation
        for(int row=points.length-2;row>=0;row--){

            long[] left = new long[points[0].length];
            long[] right = new long[points[0].length];

            left[0] = dp[row+1][0];
            right[right.length-1] = dp[row+1][points[0].length-1];

            for(int i=1;i<left.length;i++)
                left[i] = Math.max(left[i-1]-1,dp[row+1][i]);
            for(int j=right.length-2;j>=0;j--)
                right[j] = Math.max(right[j+1]-1,dp[row+1][j]);



            for(int col=0;col<points[0].length;col++){
                long temp = 0;
                // for(int j=0;j<points[0].length;j++)
                //     temp = Math.max(temp,dp[row+1][j]-Math.abs(j-col));
                dp[row][col] = (Math.max(left[col],right[col])+points[row][col]);
            }
        }

        for(long[] temp:dp)
            System.out.println(Arrays.toString(temp));


        for(int j=0;j<points[0].length;j++)
            ans = Math.max(ans,dp[0][j]);

        return ans;
    }
}









