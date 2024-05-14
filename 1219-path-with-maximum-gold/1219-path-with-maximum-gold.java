class Solution {

    int[] dr,dc;

    public int Util(int row,int col,int[][] grid,boolean[][] visited){


        int maxm = 0;
        visited[row][col] = true;

        for(int i=0;i<4;i++){

            int nr = row+dr[i],nc = col+dc[i];

            if(nr<grid.length && nr>=0 && nc>=0 && nc<grid[0].length && !visited[nr][nc] && 
                grid[nr][nc] != 0)
                maxm = Math.max(maxm,Util(nr,nc,grid,visited));
        }

        visited[row][col] = false;

        return maxm+grid[row][col];

    }


    public int getMaximumGold(int[][] grid) {

        dr = new int[]{-1,1,0,0};        
        dc = new int[]{0,0,-1,1};
        
        int maxm = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0)
                    continue;
                
                maxm = Math.max(maxm,Util(i,j,grid,visited));
            }
        }

        return maxm;

    }
}


