//Counting sort
//Reference : https://www.youtube.com/results?search_query=gurudev+guided+meditation
//Time : O(N+K)
//N stands for Size of the array
//K stands for difference between max and min values of the array
//Space : Constant since we are manipulting the given array

class Solution {
    public int[] sortArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i:nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        
        int index = 0;
        for(int i=min;i<=max;i++){
            if(!hm.containsKey(i) || hm.get(i)<=0)
                continue;
            
            int count = hm.get(i);
            
            while(count>0){
                nums[index] = i;
                count-=1;
                index+=1;
            }
            
        }
        return nums;
    }
}