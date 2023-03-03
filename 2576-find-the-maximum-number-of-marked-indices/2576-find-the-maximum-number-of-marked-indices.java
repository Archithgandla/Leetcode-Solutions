//Intuition not clear :(


class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int idx = 0;
        Arrays.sort(nums);
        
        for(int i=(nums.length+1)/2;i<nums.length;i++){
            if(nums[idx]*2<=nums[i])
                idx+=1;
        }
        return idx*2;
    }
}