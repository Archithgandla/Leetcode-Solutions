class Solution {
    public int numSpecial(int[][] mat) {
        
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        
        
        //Calculating the number of 1's in each row and each column
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    rows[i]+=1;
                    cols[j]+=1;
                }
            }
        }
        
        int ans = 0;
        

        
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<cols.length;j++){
                
                if(rows[i]+cols[j] == 2 && mat[i][j] == 1)
                    ans+=1;
                
            }
        }
        
        
        return ans;
        
        
    }
}