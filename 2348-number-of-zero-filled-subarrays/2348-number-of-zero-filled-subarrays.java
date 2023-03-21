class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int i=0,j=0;
        long ans = 0;
        
        while(j<nums.length){
            
            while(j<nums.length && nums[j]==0)
                j+=1;
            
            long count = j-i;
            ans+=(count*(count+1)/2);
            j+=1;
            i=j;
        }
        return ans;
    }
}