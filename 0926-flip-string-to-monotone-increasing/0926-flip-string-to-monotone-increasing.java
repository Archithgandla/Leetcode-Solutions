class Solution {

//Here choice is available for us wheter to flip or not
//This gives intuition for DP
//Refer codestory  
    int Util(String s,int prev,int index,int[][] dp){
        if(index == s.length())
            return 0;
        
        else if(dp[index][prev] != -1)
            return dp[index][prev];

        int flip = Integer.MAX_VALUE,no_flip = Integer.MAX_VALUE;
        if(s.charAt(index) == '1'){
            if(prev == 0){
                flip = 1+Util(s,0,index+1,dp);
                no_flip = Util(s,1,index+1,dp);
            }
            else{
                no_flip = Util(s,1,index+1,dp); 
            }
        }
        else{

            if(prev == 0){
                flip = 1+Util(s,1,index+1,dp);
                no_flip = Util(s,0,index+1,dp);    
            }
            else
                flip = 1+Util(s,1,index+1,dp);
        }
        return dp[index][prev] = Math.min(flip,no_flip);
    
    }
    
    
    public int minFlipsMonoIncr(String s) {

        int[][] dp = new int[s.length()][2];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=1;j++)
                dp[i][j] = -1;
        }

        return Util(s,0,0,dp);
    }
}