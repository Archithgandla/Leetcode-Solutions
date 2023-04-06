class Solution {

    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};

    public void DFS(int row,int col,int[][] grid){
        grid[row][col] = 1;

        for(int i=0;i<4;i++){
            if(row+dr[i] >=0 && row+dr[i]<grid.length && col+dc[i]>=0 && 
            col+dc[i]<grid[0].length && grid[row+dr[i]][col+dc[i]] == 0)
                DFS(row+dr[i],col+dc[i],grid);            
        }
    }

    
    
    public int closedIsland(int[][] grid) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<grid.length;i++)
            adj.add(new ArrayList<>());

        //Covering all the lands which are connected to water with water
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i] == 0)
                DFS(0,i,grid);
        }


        for(int i=0;i<grid[0].length;i++){
            if(grid[grid.length-1][i] == 0)
                DFS(grid.length-1,i,grid);
        }


        for(int i=0;i<grid.length;i++){
            if(grid[i][0] == 0)
                DFS(i,0,grid);
        }


        for(int i=0;i<grid.length;i++){
            if(grid[i][grid[0].length-1] == 0)
                DFS(i,grid[0].length-1,grid);
        }


        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++)
        //         System.out.print(grid[i][j]+" ");
        //     System.out.println();
        // }


        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    count+=1;
                    DFS(i,j,grid);
                }
            }
        }
        return count;
    }
}


