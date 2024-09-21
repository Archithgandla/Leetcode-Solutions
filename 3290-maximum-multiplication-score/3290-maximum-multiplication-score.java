class Solution {
    
    public long Util(int aIdx,int idx,int[] a,int[] b,long[][] dp){
        
        
        //System.out.println(aIdx+" "+idx);
        
        if(aIdx == 4)
            return 0;
        
        if(idx == b.length)
            return (long) -1e9;
        
        if(dp[aIdx][idx] != -1)
            return dp[aIdx][idx];
                            
        //take
        long take = (long)a[aIdx]*b[idx]+Util(aIdx+1,idx+1,a,b,dp);
        
        //Non Take
        long notTake = Util(aIdx,idx+1,a,b,dp);
        
        return dp[aIdx][idx] = Math.max(take,notTake);
    }
    
    
    public long maxScore(int[] a, int[] b) {
        

        if(b.length == 4)
            return (long)a[0]*b[0]+(long)a[1]*b[1]+(long)a[2]*b[2]+(long)a[3]*b[3];


        long[][] dp = new long[4][b.length];
        
        
        for(long[] arr:dp)
            Arrays.fill(arr,-1);
         
        return Util(0,0,a,b,dp);
    }
}


