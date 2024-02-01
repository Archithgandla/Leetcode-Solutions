class Solution {
    public int[][] divideArray(int[] nums, int k) {
        
        
        //[1,3,4,8,7,9,3,5,1]
        //[1,1,3,3,4,5,7,8,9]

        //[1,3,3,2,7,3]
        //[1,2,3,3,3,7]

        if(nums.length%3 != 0)
            return new int[0][];

        int[][] ans = new int[nums.length/3][3];
        Arrays.sort(nums);
        int i=0;

        while(i<nums.length){

            if(nums[i+2]-nums[i]>k)
                return new int[0][];

            ans[((i+3)/3)-1][0] = nums[i];
            ans[((i+3)/3)-1][1] = nums[i+1];
            ans[((i+3)/3)-1][2] = nums[i+2];

            i+=3;
        }

        return ans;
        
    }
}