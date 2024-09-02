class Solution {
    
    public boolean Util(int[][] grid1,int[][] grid2,int row,int col){



        int[] dr = new int[]{-1,1,0,0};
        int[] dc = new int[]{0,0,-1,1};
        boolean tempAns = grid1[row][col] != 0;
        grid1[row][col] = 2;
        

        for(int i=0;i<4;i++){
            
            int new_row = row+dr[i];
            int new_col = col+dc[i];

            if(new_row<0 || new_row>=grid2.length || new_col<0 || new_col>=grid2[0].length)
                continue;

            if(grid2[new_row][new_col] == 0 || grid1[new_row][new_col] == 2)
                continue;

            if(!Util(grid1,grid2,new_row,new_col))
                tempAns = false;
        }
        return tempAns;
    }
    
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {


        int count = 0;

        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[0].length;j++){

                if(grid2[i][j] == 0 || grid1[i][j] == 2)
                    continue;
                //System.out.println(i+" "+j);
                count+=(Util(grid1,grid2,i,j)?1:0);

                // for(int[] arr:grid1)
                //     System.out.println(Arrays.toString(arr));
                // System.out.println(count);
            }
        }

        return count;

    }
}





