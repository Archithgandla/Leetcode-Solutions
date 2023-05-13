class Solution {

    //Memoization
    public long Util(int low,int high,int zero,int one,int len,long[] dp){

        if(len>high)
            return 0;

        if(dp[len] != -1)
            return dp[len]; 

        long count = len>=low?1:0;
        //Adding zeroes
        count+=(Util(low,high,zero,one,len+zero,dp))%(long)(1e9+7);

        //Adding Ones
        count+=(Util(low,high,zero,one,len+one,dp))%(long)(1e9+7);

        return dp[len] = count%(long)(1e9+7);

    }

    //
    public int countGoodStrings(int low, int high, int zero, int one) {

        long[] dp = new long[high+1];
        //Arrays.fill(dp,-1);

        for(int i=high;i>=0;i--){
            long count = i>=low?1:0;

            //Adding zeroes
            if(i+zero<=high)
                count+=(dp[i+zero])%(long)(1e9+7);

            //Adding Ones
            if(i+one<=high)
                count+=(dp[i+one])%(long)(1e9+7);

            dp[i] = count%(long)(1e9+7);
            //System.out.println("count : "+count);
        }


        return (int)dp[0];
    }
}