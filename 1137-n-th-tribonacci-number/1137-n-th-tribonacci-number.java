class Solution {
    
    int Util(int n,int[] dp){
        if(n==0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        else if(dp[n] != -1)
            return dp[n];
        return dp[n] = Util(n-1,dp)+Util(n-2,dp)+Util(n-3,dp);
    }
    
    public int tribonacci(int n) {
        
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++)
            dp[i] = -1;
        return Util(n,dp);
    }
}