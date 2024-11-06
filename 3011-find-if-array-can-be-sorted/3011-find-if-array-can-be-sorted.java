class Solution {
    public boolean canSortArray(int[] nums) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i:nums){
            int count = 0,n = i;
            while(n>0){
                count+=((n&1) == 1?1:0);
                n = n>>1;
            }
            hm.put(i,count);
        }
        //System.out.println(hm);

        while(true){

            boolean swapped = false;
            for(int i=1;i<nums.length;i++){
                if(nums[i]>=nums[i-1] || hm.get(nums[i]) != hm.get(nums[i-1]))
                    continue;
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
                swapped = true;
            }
            //System.out.println(Arrays.toString(nums));
            if(!swapped)
                break;
        }
        System.out.println(Arrays.toString(nums));

        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1])
                return false;
        }
        return true;
    }
}






