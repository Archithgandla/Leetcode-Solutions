//Refer https://www.youtube.com/watch?v=y9yo1kyW7Bg

class Solution {
    
    public int Util(int n,int k,int[][] dp){

        if(n == 0)
            return 0;
        if(k == 0)
            return 1;
        
        if(dp[n][k] != -1)
            return dp[n][k];

        long ans = 0;

        for(int i=0;i<=Math.min(k,n-1);i++){
            ans = (ans+Util(n-1,k-i,dp))%(int)(1e9+7);
        }

        return dp[n][k] = (int)ans;

    }    

    
    
    public int kInversePairs(int n, int k) {
        
        int[][] dp = new int[n+1][k+1];

        for(int[] arr:dp)
            Arrays.fill(arr,-1);

        return Util(n,k,dp);
                    
    }
}








