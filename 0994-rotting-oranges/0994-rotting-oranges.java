class Pair{
    int row,col,t;

    Pair(int row,int col,int t){
        this.row = row;
        this.col = col;
        this.t = t;
    }
}



class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;

        //BFS
        //Manipulating the giving grid itself

        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2)
                    q.add(new Pair(i,j,0));
            }
        }

        int[] delRow = new int[]{0,-1,0,1};
        int[] delCol = new int[]{-1,0,1,0};

        while(q.size()>0){
            Pair p = q.poll();
            time = Math.max(time,p.t);

            int row = p.row;
            int col = p.col;
            int t = p.t;

            for(int i=0;i<4;i++){
                if(row+delRow[i]>=0 && row+delRow[i]<grid.length && col+delCol[i]>=0
                && col+delCol[i]<grid[0].length && grid[row+delRow[i]][col+delCol[i]] == 1){
                    grid[row+delRow[i]][col+delCol[i]] = 2;
                    q.add(new Pair(row+delRow[i],col+delCol[i],t+1));
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++)
                if(grid[i][j] == 1)
                    return -1;
        }
        return time;

    }
}