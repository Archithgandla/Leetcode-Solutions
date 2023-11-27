class Solution {


    long Util(char[][] mat,int row,int col,int moves,long[][][] dp){

        if(row<0 || col<0 || row>3 || col>2 || mat[row][col] == '-')
            return 0;

        if(moves == 0)
            return 1;
        

        if(dp[row][col][moves] != -1)
            return (int)dp[row][col][moves];
        

        long ans = 0;

        ans = (ans+Util(mat,row-2,col+1,moves-1,dp))%(int)(1e9+7);
        ans = (ans+Util(mat,row-1,col+2,moves-1,dp))%(int)(1e9+7);
        ans = (ans+Util(mat,row+1,col+2,moves-1,dp))%(int)(1e9+7);
        ans = (ans+Util(mat,row+2,col+1,moves-1,dp))%(int)(1e9+7);
        ans = (ans+Util(mat,row+2,col-1,moves-1,dp))%(int)(1e9+7);
        ans = (ans+Util(mat,row+1,col-2,moves-1,dp))%(int)(1e9+7);
        ans = (ans+Util(mat,row-1,col-2,moves-1,dp))%(int)(1e9+7);
        ans = (ans+Util(mat,row-2,col-1,moves-1,dp))%(int)(1e9+7);

        return dp[row][col][moves] = ans%(int)(1e9+7);
    }


    public int knightDialer(int n) {

        char[][] mat = new char[4][3];
        int counter = 1;

        for(int i=0;i<mat.length-1;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j] = (char)(counter+'0');
                counter+=1;
            }
        }
        mat[3][0] = '-';
        mat[3][1] = '0';
        mat[3][2] = '-';

        long ans = 0;

        long[][][] dp = new long[mat.length][mat[0].length][n+1];

        for(long[][] arr:dp){
            for(long[] temp:arr)
                Arrays.fill(temp,-1);
        }


        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == '-')
                    continue;
                //System.out.println(mat[i][j]);
                ans = (ans+Util(mat,i,j,n-1,dp))%(int)(1e9+7);
            }   
        }

        return (int)ans;

    }
}








