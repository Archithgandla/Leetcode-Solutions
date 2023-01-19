class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        //Approach-1
        //Find all the subararys and calculate the sum

        //Approach-2
        //Remainder act as key for prefix sums
        //if a remainer occur again that means a multiple
        //of k has been added thats why same remainder has occured
        //ex : (a)%k = (a+x)%k that mean x%k = 0
        //x is the sum of the sub array
        //that means sum of the subarray is zero

        HashMap<Integer,Integer> hm = new HashMap<>();
        //if subarray starting with index 0 is divisible by k
        //to accomodate that case
        hm.put(0,1);
        int ans = 0,sum = 0;

        for(int i:nums){
            sum+=i;
            int rem = (sum%k);
            
            //To always have a positive remainder
            if(rem<0)
                rem+=k;

            if(hm.containsKey(rem))
                ans+=(hm.get(rem));
            
            hm.put(rem,hm.getOrDefault(rem,0)+1);
        }
        return ans;           
    }
}