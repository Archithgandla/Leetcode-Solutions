class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0,ans = 0,i=0,j=0;

        while(j<nums.length){
            if(nums[j]%2 != 0)
                count+=1;
            
            

            while(count == k){
                ans+=1;
                int temp = j+1;
                while(count == k && temp<nums.length && nums[temp]%2 == 0){
                    temp+=1;
                    ans+=1;
                    //System.out.println("hello");
                }

                //System.out.println("ith : "+nums[i]);
                if(nums[i]%2 != 0)
                    count-=1;
                //System.out.println("count : "+count);
                i+=1;
            }
            j+=1;
        }
        return ans;
    }
}