class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        
        int sum = 0,ans = 0;
        
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i] == 1?1:-1);
            
            
            if(hm.containsKey(sum)){
                ans = Math.max(ans,i-hm.get(sum));
                continue;
            }
            
            hm.put(sum,i);
        }
        
        return ans;
        
        
        
        
        
    }
}