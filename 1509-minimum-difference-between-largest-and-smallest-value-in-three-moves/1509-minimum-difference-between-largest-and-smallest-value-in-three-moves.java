class Solution {
    public int minDifference(int[] nums) {
        
        
        if(nums.length<=4)
            return 0;
        
        Arrays.sort(nums);
    
        int minm = Integer.MAX_VALUE;
        
        int n = nums.length;
        
        minm = Math.min(minm,nums[n-1]-nums[3]);
        minm = Math.min(minm,nums[n-4]-nums[0]);
        minm = Math.min(minm,nums[n-3]-nums[1]);
        minm = Math.min(minm,nums[n-2]-nums[2]);
        
        return minm;
        
    }
}
