class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++)
            hm.put(nums[i],i);

        for(int[] arr:operations){
            nums[hm.get(arr[0])] = arr[1];
            hm.put(arr[1],hm.get(arr[0]));
            //hm.remove(arr[0]);
        }
        return nums;
    }
}










