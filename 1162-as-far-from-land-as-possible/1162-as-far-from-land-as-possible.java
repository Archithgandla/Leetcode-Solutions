class Pair{
    int row = -1;
    int col = -1;

    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}


//BFS Method
class Solution {
    public int maxDistance(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    q.add(new Pair(i,j));
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = new int[]{0,0,-1,1};
        int[] dc = new int[]{-1,1,0,0};


        int max = -1;
        while(q.size()>0){
            Pair temp = q.poll();
            int row = temp.row;
            int col = temp.col;

            for(int i=0;i<4;i++){
                if(row+dr[i]>=0 && row+dr[i]<grid.length
                && col+dc[i]>=0 && col+dc[i]<grid[0].length &&
                !visited[row+dr[i]][col+dc[i]]){
                    visited[row+dr[i]][col+dc[i]] = true;
                    dist[row+dr[i]][col+dc[i]] = 1+(dist[row][col]);
                    max = Math.max(max,dist[row+dr[i]][col+dc[i]]);
                    q.add(new Pair(row+dr[i],col+dc[i]));
                }
            }
        }
        return max;
    }
}

