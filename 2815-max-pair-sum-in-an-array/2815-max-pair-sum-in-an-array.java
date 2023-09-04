class Solution {

    int max_digit(int num){

        int maxm = Integer.MIN_VALUE;

        while(num>0){
            maxm = Math.max(maxm,num%10);
            num/=10;
        }
        return maxm;
    }

    public int maxSum(int[] nums) {
        //Approach-1
        //Consider all possible pairs 
        //and check if they have same max digit
        //If yes consider them for our answer
        //Time complexity : O(N^2)
        //Space : O(1)

        // int maxm = Integer.MIN_VALUE;

        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(max_digit(nums[i]) == max_digit(nums[j]))
        //             maxm = Math.max(maxm,nums[i]+nums[j]);
        //     }
        // }
        // return maxm == Integer.MIN_VALUE?-1:maxm;


        //Approach - 2
        //Similar to two sum problem
        //Traverse through the array
        //and use hashmap to store max digit and its corresponding number
        //If the current number max_digit key is already present in the hashmap
        //that means already a number with our current number max_digit has occured
        //so sum up them and compared with our answer
        //Now update the hashmap max_digit key with maximum(current,previous number with max_digit)
        //Time complexity : O(N)
        //Space : O(N)

        HashMap<Integer,Integer> hm = new HashMap<>();
        int maxm = Integer.MIN_VALUE;

        for(int i:nums){
            
            int max_digit = max_digit(i);

            if(!hm.containsKey(max_digit)){
                hm.put(max_digit,i);
                continue;
            }

            maxm = Math.max(maxm,i+hm.get(max_digit));
            hm.put(max_digit,Math.max(i,hm.get(max_digit)));
        }
        return maxm == Integer.MIN_VALUE?-1:maxm;
    }
}


