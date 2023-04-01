class Solution {

    boolean Util(String s1,String s2,String s3,int i,int j,int k,int[][][] dp){
        if(k == s3.length())
            return true;
        
        if(dp[i][j][k] != -1)
            return dp[i][j][j] == 1?true:false;


        boolean first = false,second = false;

        if(i<s1.length() && s1.charAt(i) == s3.charAt(k))
            first = Util(s1,s2,s3,i+1,j,k+1,dp);
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k))
            second = Util(s1,s2,s3,i,j+1,k+1,dp);

        dp[i][j][k] = first||second?1:0;
        return first||second;
    }


    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length())
            return false;

        int[][][] dp = new int[s1.length()+1][s2.length()+1][s1.length()+s2.length()];

        for(int i=0;i<dp.length;i++){
            for(int[] arr:dp[i])
                Arrays.fill(arr,-1);
        }


        return Util(s1,s2,s3,0,0,0,dp);        
    }
}