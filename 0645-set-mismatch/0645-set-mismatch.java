class Solution {
    public int[] findErrorNums(int[] nums) {

        int repeat = -1,sum = 0;

        for(int i=0;i<nums.length;i++){

            if(nums[Math.abs(nums[i])-1]<0){
                repeat = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i])-1]*=-1;
        }

        for(int i=0;i<nums.length;i++){
            
            if(nums[i]<0)
                nums[i]*=-1;
            sum+=nums[i];
        }
        int missing = ((nums.length*(nums.length+1))/2)-(sum-repeat);


        return new int[]{repeat,missing};

    }
}



