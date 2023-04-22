class Solution {

    public int Util(String s,int i,int j,int[][] dp){
        if(i >= j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        //System.out.println(i+" "+j);
        if(s.charAt(i) == s.charAt(j))
            return Util(s,i+1,j-1,dp);
        
        int ans = Integer.MAX_VALUE;

        if(i+1<s.length())
            ans = Math.min(ans,1+Util(s,i+1,j,dp));

        if(j-1>=0)
            ans = Math.min(ans,1+Util(s,i,j-1,dp));
        //System.out.println(ans);
        return dp[i][j] = ans;
    }

    public int minInsertions(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for(int[] arr:dp)
            Arrays.fill(arr,-1);

        return Util(s,0,s.length()-1,dp);
    }
}