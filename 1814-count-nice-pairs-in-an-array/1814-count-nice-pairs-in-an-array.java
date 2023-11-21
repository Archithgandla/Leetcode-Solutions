class Solution {

    public long rev(int num){

        long sum = 0;

        while(num>0){

            long digit = num%10;
            sum = sum*10+digit;
            num/=10;
        }

        return sum;
    }
    
    public int countNicePairs(int[] nums) {

        //Approach - 1
        //Try all possible pairs and then just count them
        //Time complexity : O(N^2)
        //Space complexity : O(1)
        //TLE


        //Approach - 2
        //The required equation is
        //nums[i]+rev(nums[j]) = nums[j]+rev(nums[i])
        //rearranging the terms
        //nums[i]-rev(nums[i]) = nums[j]-rev(nums[j])
        //So we just have to find pairs of numbers for which
        //number-rev(number) is same
        //This is just like two sum problem


        long count = 0;
        HashMap<Long,Integer> hm = new HashMap<>();

        for(int i:nums){
            
            long curr = i-rev(i);
            
            //System.out.println(hm.getOrDefault(curr,0));
            count = (count+hm.getOrDefault(curr,0))%(int)(1e9+7);
            
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }

        //System.out.println(hm);

        return (int)count;

    }
}





