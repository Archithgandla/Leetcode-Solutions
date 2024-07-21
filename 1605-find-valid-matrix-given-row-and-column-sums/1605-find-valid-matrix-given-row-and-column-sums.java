class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        
        //Refer CodeStoryWithMik Video


        int[][] ans = new int[rowSum.length][colSum.length];
        int i=0,j=0;
        

        while(i<rowSum.length && j<colSum.length){

            if(rowSum[i]<colSum[j]){
                colSum[j]-=rowSum[i];
                ans[i][j] = rowSum[i]; 
                rowSum[i] = 0;
                i+=1;
                continue;
            }

            rowSum[i]-=colSum[j];
            ans[i][j] = colSum[j]; 
            colSum[j] = 0;
            j+=1;

        }

        return ans;

    }
}