class Solution {
    public int minOperations(int[] nums) {
        
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i:nums)
            hm.put(i,hm.getOrDefault(i,0)+1);
        
        
        
        int ans = 0;
        
        
        for(int k:hm.keySet()){
            
            if(hm.get(k) == 1)
                return -1;
            
            if(hm.get(k)%3 == 0)
                ans+=(hm.get(k)/3);
            
            else if(hm.get(k)%3 == 1)
                ans+=((hm.get(k)/3)-1+2);
            
            else if(hm.get(k)%3 == 2)
                ans+=((hm.get(k)/3)+1);
        }
        
        return ans;
        
        
        
    }
}