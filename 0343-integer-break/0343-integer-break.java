class Solution {


    //Memoization
    public int Util(int N,int[] dp){

        if(N == 0 || N == 1)
            return 1;
        
        if(dp[N] != -1)
            return dp[N];

        int maxm = Integer.MIN_VALUE;

        for(int i=1;i<=N;i++)
            maxm = Math.max(maxm,i*Util(N-i,dp));
        return dp[N] = maxm;
    }


    
    public int integerBreak(int n){
        //Tabulation
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;


        for(int i=2;i<dp.length;i++){
            int maxm = Integer.MIN_VALUE;

            for(int j=1;j<=i;j++)
                maxm = Math.max(maxm,j*dp[i-j]);
            dp[i] = maxm;
        }

        return dp[n];
        
    }
}










