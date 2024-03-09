class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        //Approach-1
        //Use Nested loops
        //For each element in nums1 search in nums2
        //TC : O(N^2)
        //SC : O(1)

        //Approach-2
        //Use a hashmap
        //TC : O(N)
        //SC : O(N)


        //Approach-3
        //Using two pointer, similar to merge sort merge function

        int i=0,j=0;

        while(i<nums1.length && j<nums2.length){

            if(nums1[i] == nums2[j])
                return nums1[i];
            
            else if(nums1[i]<nums2[j])
                i+=1;
            else
                j+=1;
        }

        return -1;
    }
}


