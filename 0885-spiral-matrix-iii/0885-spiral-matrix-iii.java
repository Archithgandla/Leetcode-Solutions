
class Pair{
    int row,col;

    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}



class Solution {

    public int IsValid(int i,int j,int rows,int cols,int[][] ans,int ansIdx){
        
        if(i>=0 && j>=0 && i<rows && j<cols){
            ans[ansIdx] = new int[]{i,j};
            return 1;
        }

        return 0;

    }


    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        
        Pair[] arr = new Pair[4];
        arr[0] = new Pair(0,1);
        arr[1] = new Pair(1,0);
        arr[2] = new Pair(0,-1);
        arr[3] = new Pair(-1,0);
        int count = 0,steps = 1,idx = 0,i = rStart,j = cStart,ansIdx = 0;
        int[][] ans = new int[rows*cols][1];

        while(count<rows*cols){
            
            int temp = steps;
            while(temp>0){

                int inGrid = IsValid(i,j,rows,cols,ans,ansIdx);
                count+=inGrid;
                ansIdx+=inGrid;

                i+=arr[idx].row;
                j+=arr[idx].col;
                temp-=1;
            }

            idx = (idx+1)%4;
            steps+=(idx%2 == 0?1:0);
        }

        return ans;

    }
}





