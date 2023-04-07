class Solution {
    
    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};

    public void DFS(int row,int col,int[][] grid){
        grid[row][col] = 0;

        for(int i=0;i<4;i++){
            if(row+dr[i]>=0 && row+dr[i]<grid.length && col+dc[i]>=0 && 
            col+dc[i]<grid[0].length && grid[row+dr[i]][col+dc[i]] == 1)
                DFS(row+dr[i],col+dc[i],grid);
        }

    }
    
    
    public int numEnclaves(int[][] grid) {

        for(int i=0;i<grid.length;i++){
            if(grid[i][0] == 1)
                DFS(i,0,grid);
        }

        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length-1] == 1)
                DFS(i,grid[0].length-1,grid);
        }

        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i] == 1)
                DFS(0,i,grid);
        }

        for(int i=0;i<grid[0].length;i++){
            if(grid[grid.length-1][i] == 1)
                DFS(grid.length-1,i,grid);
        }

        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++)
                count+=(grid[i][j] == 1?1:0);
        }
        return count;

    }
}