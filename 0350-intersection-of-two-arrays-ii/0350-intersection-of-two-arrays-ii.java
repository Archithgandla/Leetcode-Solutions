class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        
        //Approach-1
        //Use hashamps to calcualte frequencies in both arrays and compare them
        
        
        //Approach-2
        //Sort the arrays and apply merge sorted arrays technique
        
        
        //Approach-3
        //count sort
        
        int[] arr = new int[1001];
        
        for(int i=0;i<nums1.length;i++)
            arr[nums1[i]]+=1;
        
        
        ArrayList<Integer> Al = new ArrayList<>();
        
        
        for(int i=0;i<nums2.length;i++){
            
            if(arr[nums2[i]]>0){
                Al.add(nums2[i]);
                arr[nums2[i]]-=1;
            }
            
        }
        
    
        int[] ans = new int[Al.size()];
        
        for(int i=0;i<Al.size();i++)
            ans[i] = Al.get(i);
        
        return ans;
    }
}





