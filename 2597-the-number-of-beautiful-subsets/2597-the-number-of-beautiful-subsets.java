class Solution {

    public int Util(int[] nums,int idx,HashMap<Integer,Integer> hm,int k){

        if(idx == nums.length)
            return hm.size()>0?1:0;
        
        int count = 0;

        if(!hm.containsKey(nums[idx]-k) && !hm.containsKey(nums[idx]+k)){
            
            hm.put(nums[idx],hm.getOrDefault(nums[idx],0)+1);
            count+=(Util(nums,idx+1,hm,k));
            
            if(hm.get(nums[idx])>1)
                hm.put(nums[idx],hm.getOrDefault(nums[idx],0)-1);
            else
                hm.remove(nums[idx]);
            
        }


        count+=Util(nums,idx+1,hm,k);

        return count;
    }
    
    public int beautifulSubsets(int[] nums, int k) {
        
        return Util(nums,0,new HashMap<Integer,Integer>(),k);
    }

}





