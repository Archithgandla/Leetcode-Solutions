class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        
        int i=0,index = 0;
        
        while(i<nums.length){
            
            if(nums[i]%2 != 0){
                i+=1;
                continue;
            }
            
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            
            i+=1;
            index+=1;
        
        }
        
        return nums;
        
    }
}