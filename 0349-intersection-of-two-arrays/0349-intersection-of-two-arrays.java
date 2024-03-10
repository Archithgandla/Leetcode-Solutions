class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        
        for(int i:nums1)
            hm.put(i,1);
        
        for(int i:nums2){
            if(hm.containsKey(i) && hm.get(i) == 1){
                hm.put(i,hm.get(i)+1);
                count+=1;
            }
        
        }
        
        int[] ans = new int[count];
        int idx = 0;
        
        for(int i:nums2){
            if(hm.containsKey(i) && hm.get(i)>1){
                ans[idx] = i;
                idx+=1;
                hm.put(i,1);
            }
        }
        
        return ans;
        
    }
}



