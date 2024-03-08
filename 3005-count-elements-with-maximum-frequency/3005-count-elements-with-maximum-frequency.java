class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int maxm = Integer.MIN_VALUE,count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();


        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
            maxm = Math.max(maxm,hm.get(i));
        }
        

        for(int k:hm.keySet())
            count+=(hm.get(k) == maxm?1:0);
        
        return count*maxm;
        
    }
}




