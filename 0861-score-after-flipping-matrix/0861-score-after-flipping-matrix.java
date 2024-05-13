class Solution {
    public int matrixScore(int[][] grid) {
        
        //row flips
        for(int i=0;i<grid.length;i++){
            
            if(grid[i][0] == 1)
                continue;

            for(int j=0;j<grid[i].length;j++)
                grid[i][j] = grid[i][j] == 0?1:0;
        }

        //col flips

        for(int j=0;j<grid[0].length;j++){

            int count = 0;

            for(int i=0;i<grid.length;i++)
                count+=(grid[i][j] == 1?1:0);
            
            int par = grid.length%2 == 0?grid.length/2:(grid.length/2)+1;

            if(count>=par)
                continue;
            
            for(int i=0;i<grid.length;i++)
                grid[i][j]=(grid[i][j] == 1?0:1);

        }


        int ans = 0;

        int[] pow = new int[grid[0].length];
        pow[pow.length-1] = 1;

        for(int i=pow.length-2;i>=0;i--)
            pow[i] = pow[i+1]*2;

        //System.out.println(Arrays.toString(pow));


        for(int i=0;i<grid.length;i++){

            //System.out.println(Arrays.toString(grid[i]));
            for(int j=0;j<grid[0].length;j++)
                ans+=(grid[i][j]*pow[j]);
            
            //System.out.println(ans);
        }


        return ans;


    }
}





