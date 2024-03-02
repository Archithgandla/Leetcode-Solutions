class Solution {
    public int[] sortedSquares(int[] nums) {


        int start = 0,end = nums.length-1;
        int[] ans = new int[nums.length];


        for(int i=nums.length-1;i>=0;i--){

            if(Math.abs(nums[start])>Math.abs(nums[end])){
                ans[i] = nums[start]*nums[start];
                start+=1;
            }
            else{
                ans[i] = nums[end]*nums[end];
                end-=1;
            }

        }

        return ans;

    }
}