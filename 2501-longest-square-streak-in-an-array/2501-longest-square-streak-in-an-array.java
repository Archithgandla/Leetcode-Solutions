class Solution {
    
    
    int BS(int[] nums,int start,int end,int target){

        int low = 0,high = end;
        int mid = low+(high-low)/2;

        while(low<=high){

            if(nums[mid] == target)
                return mid;
            else if(nums[mid]>target)
                high = mid-1;
            else
                low = mid+1;
            mid = low+(high-low)/2;
        }
        return -1;
    }



    public int Util(int index,int[] nums){
        if(index == nums.length)
            return 0;

        double sqrt = Math.sqrt(nums[index]);

        if(sqrt-Math.floor(sqrt) != 0)
            return 0;

        int target = BS(nums,0,index-1,(int)sqrt);
        //System.out.println(index+" "+target);

        if(target == -1)
            return 0;
        return 1+Util(target,nums);
    }
    
    public int longestSquareStreak(int[] nums) {
        
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int maxm = 1;

        for(int i=nums.length-1;i>=0;i--)
            maxm = Math.max(maxm,1+Util(i,nums));

        return maxm == 1?-1:maxm;
    }
}






