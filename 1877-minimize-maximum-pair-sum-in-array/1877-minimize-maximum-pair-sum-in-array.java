class Solution {
    public int minPairSum(int[] nums) {


        //1,998,999,1000

        Arrays.sort(nums);
        int maxm = Integer.MIN_VALUE;

        for(int i=0;i<nums.length/2;i++)
            maxm = Math.max(maxm,nums[i]+nums[nums.length-i-1]);

        return maxm;



    }
}





