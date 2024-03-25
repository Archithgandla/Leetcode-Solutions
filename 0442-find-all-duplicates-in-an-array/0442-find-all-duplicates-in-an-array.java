class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        
        List<Integer> Al = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            
                        
            if(nums[Math.abs(nums[i])-1]<0)
                Al.add(Math.abs(nums[i]));
            
            
            nums[Math.abs(nums[i])-1]*=-1;
        }
        
        //System.out.println(Arrays.toString(nums));
        return Al;
        
        
    }
}