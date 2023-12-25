class Solution {
    
    
    
    public int Util(String s,int index,int[] dp){
        
        if(index == s.length())
            return 1;
        
        
        if(s.charAt(index) == '0')
            return 0;

        if(dp[index] != -1)
            return dp[index];
        
        
        int ans = 0;
        
        ans+=Util(s,index+1,dp);
        
        if(index != s.length()-1 && (s.charAt(index)-'0')*10+(s.charAt(index+1)-'0')<=26)
            ans+=Util(s,index+2,dp);
        
        return dp[index] = ans;
        
    }
    
    
    
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        
        return Util(s,0,dp);
                
    }
}

