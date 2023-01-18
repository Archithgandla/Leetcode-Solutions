//Approach : https://www.youtube.com/watch?v=Za8V4wkZKkM


class Solution {

    int max_sum_subarray(int[] nums){
        int sum = 0,max = Integer.MIN_VALUE;

        for(int i:nums){
            sum+=i;
            max = Math.max(sum,max);

            if(sum<0)
                sum = 0;
        }
        return max;
    }

    int min_sum_subarray(int[] nums){
        int sum = 0,min = Integer.MAX_VALUE;

        for(int i:nums){
            sum+=i;
            min = Math.min(min,sum);

            if(sum>0)
                sum = 0;
        }
        return min;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;

        for(int i:nums)
            sum+=i;
        
        int max_sum = max_sum_subarray(nums);
        if(max_sum>0)
            return Math.max(max_sum,sum-min_sum_subarray(nums));
        return max_sum;
    }
}





