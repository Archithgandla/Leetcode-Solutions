class Solution {
    
    
    public int Util(int n,int copied,int target,int[][] dp){
        if(n == target)
            return 0;
        
        if(n>target)
            return Integer.MAX_VALUE;

        if(dp[n][copied] != -1)
            return dp[n][copied];

        int minm = Integer.MAX_VALUE;

        //paste
        if(copied+n<=target && copied>0)
            minm = Math.min(minm,Util(n+copied,copied,target,dp));
        
        //copy
        if(n != copied)
            minm = Math.min(minm,Util(n,n,target,dp));

        return dp[n][copied] = (minm != Integer.MAX_VALUE?1+minm:minm);
    }
    
    
    
    
    public int minSteps(int n) {
        
        if(n == 1)
            return 0;

        int[][] dp = new int[n+1][n+1];
        for(int[] arr:dp)
            Arrays.fill(arr,-1);

        return Util(1,0,n,dp);
    }
}






