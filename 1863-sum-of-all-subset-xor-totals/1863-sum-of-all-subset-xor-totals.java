class Solution {
    
    public int Util(int index,int[] nums,int curr){

        if(index == nums.length)
            return curr;

        int ans = 0;

        ans+=(Util(index+1,nums,curr^nums[index]));
        ans+=(Util(index+1,nums,curr));

        return ans;

    }
    
    public int subsetXORSum(int[] nums) {
        
        return Util(0,nums,0);
        
    }
}






