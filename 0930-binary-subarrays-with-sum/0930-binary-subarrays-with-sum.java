class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0,ans = 0;

        hm.put(0,1);

        for(int i:nums){
            
            sum+=i;

            if(hm.containsKey(sum-goal))
                ans+=hm.get(sum-goal);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }

        //System.out.println(hm);

        return ans;
    }
}