class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        
        //Alternate and Better Approach is using heap and outdating complex
        //refer codestory with mik


        HashMap<Integer,Long> hm = new HashMap<>();
        long[] ans = new long[nums.length];
        long maxm = 0;

        for(int i=0;i<nums.length;i++){
            
            int id = nums[i];
            int count = freq[i];

            hm.put(id,hm.getOrDefault(id,(long)0)+count);


            if(count>0){
                maxm = Math.max(hm.get(id),maxm);
                ans[i] = maxm;
                continue;
            }

            if(hm.get(id)-count != maxm){
                ans[i] = maxm;
                continue;
            }
            //System.out.println(i+" "+hm);
            maxm = 0;

            for(int k:hm.keySet())
                maxm = Math.max(maxm,hm.get(k));

            ans[i] = maxm;
        }

        return ans;

    }
}




