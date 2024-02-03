class Solution {
    
    
    public int Util(int[] arr,int index,int k,int[] dp){

        if(index == arr.length)
            return 0;
        
        if(dp[index] != -1)
            return dp[index];

        long ans = Integer.MIN_VALUE;
        int maxm = Integer.MIN_VALUE;

        for(int i=index;i<index+k && i<arr.length;i++){
            
            maxm = Math.max(maxm,arr[i]);
            ans = Math.max(ans,(i-index+1)*maxm+Util(arr,i+1,k,dp));

            //System.out.println(ans);
        }

        return dp[index] = (int)ans;

    }
    
    
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        

        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        
        return Util(arr,0,k,dp);
    
        
    }
}


