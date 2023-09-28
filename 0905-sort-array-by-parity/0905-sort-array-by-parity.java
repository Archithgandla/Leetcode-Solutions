class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        
        int i=0;
        
        while(i<nums.length){
            
            if(nums[i]%2 == 0){
                i+=1;
                continue;
            }
            
            int pre = i;
            while(i<nums.length && nums[i]%2 != 0)
                i+=1;
            
            if(i == nums.length)
                return nums;
            
            int temp = nums[pre];
            nums[pre] = nums[i];
            nums[i] = temp;
            i=pre+1;
        }
        
        return nums;
        
    }
}