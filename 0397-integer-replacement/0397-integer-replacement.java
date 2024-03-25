class Solution {
    
    
    public int Util(int n,HashMap<Integer,Integer> hm){
        
        //System.out.println(n);
        if(n == 1)
            return 0;
        
        if(hm.containsKey(n))
            return hm.get(n);
        
        int minm = Integer.MAX_VALUE;
        
        if(n%2 == 0)
            minm = Math.min(minm,1+Util(n/2,hm));
        
        else{
            minm = Math.min(minm,1+Util(n-1,hm));
            minm = Math.min(minm,1+Util(n+1,hm));
        }
        
        hm.put(n,minm);
        
        return minm;
        
    }
    
    
    
    
    
    
    public int integerReplacement(int n) {
          
        //int[] dp = new int[n];
        
        if(n == 1)
            return 0; 
        if(n == Integer.MAX_VALUE)
            return 32;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        if(n%2 == 0)
            return 1+Util(n/2,hm);
        
        return 2+Math.min(Util((n-1)/2,hm),Util((n+1)/2,hm));
            
    }
}











