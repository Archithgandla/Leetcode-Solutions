class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i:banned){
            hm.put(i,1);
        }
        
        int sum = 0,count = 0;
        
        for(int i=1;i<=n;i++){
            
            if(hm.containsKey(i))
                continue;
            sum+=i;
            
            if(sum>maxSum)  
                return count; 
            count+=1;
        }
        
        return count;
    }
}