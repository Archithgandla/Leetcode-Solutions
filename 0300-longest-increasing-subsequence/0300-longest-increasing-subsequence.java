class Solution {
    
    
    
    public int Util(int[] nums,int index,int prev_idx,int[][] dp){
        
        if(index == nums.length)
            return 0;
        
        if(dp[index][prev_idx+1] != -1)
            return dp[index][prev_idx+1];
        
        int maxm = Integer.MIN_VALUE;
        
        if(prev_idx == -1 || nums[prev_idx]<nums[index])
            maxm = Math.max(maxm,1+Util(nums,index+1,index,dp));
        
        maxm = Math.max(maxm,Util(nums,index+1,prev_idx,dp));
        
        return dp[index][prev_idx+1] = maxm;
    }
    
    
    
    
    
    
    public int lengthOfLIS(int[] nums) {
        
        
        int[][] dp = new int[nums.length+1][nums.length+1];
        
        
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        
        return Util(nums,0,-1,dp);
    }
}








