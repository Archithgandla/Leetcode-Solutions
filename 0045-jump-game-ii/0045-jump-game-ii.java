class Solution {
    public int jump(int[] nums) {
        int steps = 0;

        int i=0;

        while(i<nums.length-1){

            int k=1;
            int max = i,ans = -1;
            while(k<=nums[i]){
                if(i+k<nums.length && (i+k)+nums[i+k]>=Math.min(max,nums.length-1)){
                    max = (i+k)+nums[i+k];
                    ans = i+k;
                }
                k+=1;
            }
            i = ans;
            steps+=1;
        }
        return steps;
    }
}