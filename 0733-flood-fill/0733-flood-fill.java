class Solution {


    int[] delRow = new int[]{0,-1,0,+1};
    int[] delCol = new int[]{-1,0,1,0};

    void DFS(int[][] image,int row,int col,int color,int target){
        for(int i=0;i<4;i++){
            if(row+delRow[i]>=0 && row+delRow[i]<image.length && col+delCol[i]>=0 &&
            col+delCol[i]<image[0].length && image[row+delRow[i]][col+delCol[i]] == color
            ){
                image[row+delRow[i]][col+delCol[i]] = target;
                DFS(image,row+delRow[i],col+delCol[i],color,target);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //DFS
        

        //If target and prev color is same no changes are required

        

        if(image[sr][sc] != color){
            DFS(image,sr,sc,image[sr][sc],color);
            image[sr][sc] = color;
        }
        return image;
    }
}