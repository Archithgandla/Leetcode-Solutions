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
        
        int[] dp = new int[s.length()+1];
        
        dp[s.length()] = 1;
        
        for(int i=s.length()-1;i>=0;i--){
            
            if(s.charAt(i) == '0'){
                dp[i] = 0;
                continue;
            }
            
            
            int ans = 0;
        
            ans+=dp[i+1];
        
            if(i != s.length()-1 && (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<=26)
                ans+=dp[i+2];
        
            dp[i] = ans;
        }
        
        return dp[0];
                
    }
}

