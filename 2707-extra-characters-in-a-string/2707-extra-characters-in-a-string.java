class Solution {
    
    
    public int Util(int index,String s,HashMap<String,Integer> hm,int[] dp){
        
        if(index >= s.length())
            return 0;
        if(dp[index] != -1)
            return dp[index];
        
        int minm = Integer.MAX_VALUE;
        
        for(int i=index;i<s.length();i++){
            
            if(hm.containsKey(s.substring(index,i+1)))
                minm = Math.min(minm,Util(i+1,s,hm,dp));
            
            int temp = Util(i+1,s,hm,dp);
            
            if(temp != Integer.MAX_VALUE)
                minm = Math.min(minm,(i-index+1)+temp);
        }
        
        return dp[index] = minm;
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        
        
        for(String str:dictionary)
            hm.put(str,1);
        
        
        return Util(0,s,hm,dp);
    }
}