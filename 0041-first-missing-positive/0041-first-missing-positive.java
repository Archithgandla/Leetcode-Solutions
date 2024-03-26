class Solution {
    public int firstMissingPositive(int[] nums) {
    
        //Approach - 1
        //Store the array elements in a hashamp
        //start from 1 and check the occurence of each in the array
        //return the first missing
        //tc : O(N) sc : O(N)

        //Approach - 2
        //sort the array
        //and check for the occurence of each element from 1 to misssing element
        //tc : Nlogn

        //calculate the smallest positive element
        //if it is not equal to 1
        //return 1
        //else 

        HashMap<Integer,Integer> hm = new HashMap<>();
        int minm = Integer.MAX_VALUE;

        for(int i:nums){
            if(i<=0)
                continue;
            hm.put(i,1);
            minm = Math.min(minm,i);
        }
        
        if(minm != 1)
            return 1;

        int target = minm+1;
    
        while(hm.containsKey(target))
            target+=1;

        return target;


        //*************************************************** */
        //constant space approach
        //https://www.youtube.com/watch?v=lyjOwaUEWWQ

        
    }
}






