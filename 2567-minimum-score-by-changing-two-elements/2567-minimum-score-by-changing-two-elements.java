class Solution {
    public int minimizeSum(int[] nums) {
        
        Arrays.sort(nums);

        int one = nums[nums.length-1]-nums[2];
        int two = nums[nums.length-3]-nums[0];
        int three = nums[nums.length-2]-nums[1];

        return Math.min(one,Math.min(two,three));

    }
}

//
// [58,42,8,75,28]
// [8,28,42,58,75]
// 75 75 