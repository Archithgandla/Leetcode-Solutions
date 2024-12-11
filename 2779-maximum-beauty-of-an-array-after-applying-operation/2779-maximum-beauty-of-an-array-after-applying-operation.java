class Solution {
    public int maximumBeauty(int[] nums, int k) {
        
        if(nums.length == 1)
            return 1;


        int maxm = Integer.MIN_VALUE,ans = Integer.MIN_VALUE;

        for(int i:nums)
            maxm =  Math.max(i,maxm);

        int[] arr = new int[maxm+k+2];

        for(int i:nums){
            arr[Math.max(i-k,0)]+=1;
            arr[i+k+1]-=1;
        }

        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
            ans = Math.max(ans,arr[i]);
        }


           
        return ans;
    }
}


