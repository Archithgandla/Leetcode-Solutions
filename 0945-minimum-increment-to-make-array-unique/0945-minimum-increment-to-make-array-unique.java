class Solution {
    public int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0,prev = -1;

        for(int i:nums){

            if(!hm.containsKey(i)){
                hm.put(i,1);
                prev = i;
                continue;
            }

            
            int ref = i;
            i = prev;

            while(hm.containsKey(i))
                i+=1;

            count+=(i-ref);
            hm.put(i,1);
            prev = i;
        }

        return count;

    }
}





