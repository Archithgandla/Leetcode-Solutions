class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] dp = new double[query_row+1][query_row+1];        
        dp[0][0] = poured;


        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i+1;j++){
                
                //System.out.println(i+" "+j);
                double comes_down = 0;

                if(j-1>=0 && dp[i-1][j-1]-1>0){
                    //System.out.println((dp[i-1][j-1]-1)/2.0);
                    comes_down+=((dp[i-1][j-1]-1)/2.0);
                }
                if(dp[i-1][j]-1>0){
                    //System.out.println((dp[i-1][j]-1)/2.0);
                    comes_down+=((dp[i-1][j]-1)/2.0);
                }
                dp[i][j] = comes_down;


                // if(comes_down == 0)
                //     return 0;
            }
        }


        // for(double[] arr:dp)
        //     System.out.println(Arrays.toString(arr));

        return Math.min(dp[query_row][query_glass],1);

    }
}







