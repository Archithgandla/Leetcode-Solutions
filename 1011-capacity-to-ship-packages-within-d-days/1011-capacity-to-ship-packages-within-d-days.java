class Solution {


    public boolean isValid(int[] arr,int k,int capacity){
        int count = 0,temp = 0;

        for(int j=0;j<arr.length;j++){
            int i=arr[j];
            temp+=i;

            if(temp>capacity){
                count+=1;
                temp=i;
            }
            if(j == arr.length-1)
                count+=1;
            if(count>k)
                return false;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        //Reference - neetcode
        //Very similar to koko with bananas

        int max = Integer.MIN_VALUE,sum = 0;

        for(int i:weights){
            max = Math.max(max,i);
            sum+=i;
        }

        int low = max,high = sum;
        int mid = low+(high-low)/2,ans = sum;

        while(low<=high){
            if(isValid(weights,days,mid)){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
            mid = low+(high-low)/2;
        }
        return ans;
    }
}