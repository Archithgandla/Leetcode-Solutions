class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        //Approach-1
        //Calculate all the subarrays and check min and max


        //Approach-2
        //Very tough intuition
        long count = 0;
        int recent_min = -1;//Stores the value of most recent element whose value is minK
        int recent_max = -1;//Stores the value of most recent element whose value is maxK
        int left_bound = -1; //Stores the value of most recent element whose value is outside the range

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=minK && nums[i]<=maxK){
                recent_min = nums[i] == minK?i:recent_min;
                recent_max = nums[i] == maxK?i:recent_max;


                ////**************Important step***************
                //Always starts considering the subarrays from step 1
                //Distance from min(recent_min,recent_max) is taken because
                //All the elements between them contribute to number of subaarys
                //i.e consider Example 7 2 3 1 5 4 maxK = 5,minK = 1
                //subarray 1 5 is within bounds and left bound is index 0 since nums[0] is 7 which
                //out of bounds
                //Now the subarrays possible to left of 1 are
                //2 3 1 5,3 1 5 i.e two subarrays which can be given by Math.min(recent_min,recent_max)-left_bound
                //Similarly whenever a element withinbounds is added to the right i.e 4 in the above case
                //the count gets increased like explained above
                //Max with 0 is to handle the case when mink or maxk is not yet found


                count+=(Math.max(0,Math.min(recent_min,recent_max)-left_bound));
            }
            else{
                recent_min = -1;
                recent_max = -1;
                left_bound = i;
            }
        }
        return count;
    }
}