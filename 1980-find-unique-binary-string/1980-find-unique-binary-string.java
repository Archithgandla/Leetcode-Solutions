class Solution {
    
    
    
    String ans;
    
    public boolean Util(int count,String str,HashMap<String,Integer> hm){
        
        if(count == 0 && !hm.containsKey(str)){
            ans = str;
            return true;
        }
        
        if(count == 0)
            return false;
        
        if(Util(count-1,str+'0',hm) || Util(count-1,str+'1',hm))
            return true;
        
        return false;
    }
    
    
    public String findDifferentBinaryString(String[] nums) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        ans = "";
        
        for(String str:nums)
            hm.put(str,1);
        
        Util(nums.length,"",hm);
        
        return ans;
        
    }
}