class Solution {
    //Memoization
    public long Util(int index,int[][] questions,long[] dp){
        if(index >= questions.length)
            return 0;
         if(dp[index] != -1)
            return dp[index];

        long maxi = Integer.MIN_VALUE;
        
        //Take
        maxi = Math.max(maxi,questions[index][0]+
                        Util(index+questions[index][1]+1,questions,dp));
            
        //Not take
        maxi = Math.max(maxi,Util(index+1,questions,dp));

        return dp[index] = maxi;
    }
    //Tabulation
    public long mostPoints(int[][] questions) {

        long[] dp = new long[questions.length+questions[questions.length-1][1]+1];
        
        for(int i=questions.length;i<dp.length;i++)
            dp[i] = 0;

        for(int i=questions.length-1;i>=0;i--){
            long maxi = Integer.MIN_VALUE;
        
            //Take

            if(i+questions[i][1]+1>=questions.length)
                maxi = Math.max(maxi,questions[i][0]+0);
            else
                maxi = Math.max(maxi,questions[i][0]+dp[i+questions[i][1]+1]);
            
            //Not take
            if(i+1>=questions.length)
                maxi = Math.max(maxi,questions[i][0]+0);
            else
                maxi = Math.max(maxi,dp[i+1]);

            dp[i] = maxi;
        }

        return dp[0];
    }
}