class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i:arr){
            int r = (i%k);
            
            if(r<0)
                r+=k;
            
            hm.put(r,hm.getOrDefault(r,0)+1);
        }


        
        if(hm.containsKey(0) && hm.get(0)%2 != 0)
            return false;
        
        for(int i=1;i<k;i++){
            int rem = k-i;
            
            
            if(!hm.containsKey(i) && !hm.containsKey(rem))
                continue;
                
            if((hm.containsKey(i) && !hm.containsKey(rem)) || (!hm.containsKey(i) && hm.containsKey(rem))){
                return false;
            }
            if(hm.get(i)-hm.get(rem) != 0){
                return false;
            }
            if(i == rem && hm.getOrDefault(i,0)%2 != 0)
                return false;
            
                
            
        }

        return true;

    }
}






