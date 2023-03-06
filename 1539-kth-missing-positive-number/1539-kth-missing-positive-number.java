class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i:arr)
            hm.put(i,1);
        
        int i=1;
        while(true){
            if(!hm.containsKey(i)){
                k-=1;
                
                if(k == 0)
                    return i;
            }
            i+=1;
        }
        
    }
}