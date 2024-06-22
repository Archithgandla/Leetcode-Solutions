class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        //Approach-1
        //Consider all subarrays using a nested loop and count the number
        //of subarrays with no of odd numbers equal to k

        //Approach-2
        //Sliding window but might become complex

        //Approach-3
        //hashmap

        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int odd_count = 0,ans = 0;

        for(int i:nums){
            if(i%2 == 1)
                odd_count+=1;

            hm.put(odd_count,hm.getOrDefault(odd_count,0)+1);

            ans+=(hm.getOrDefault(odd_count-k,0));
        }

        return ans;
    }
}




