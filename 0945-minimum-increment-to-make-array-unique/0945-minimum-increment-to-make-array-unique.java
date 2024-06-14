class Solution {
    public int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0,prev = -1;

        for(int i:nums){

            
            if(i>prev){
                prev = i;
                continue;
            }
            
            count+=((prev+1)-i);
            prev+=1;
        }

        return count;

    }
}





