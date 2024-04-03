class Solution {
    
    
    
    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};
    
    
    public boolean Util(int index,char[][] board,int i,int j,boolean[][] visited,String word){
        
        if(index == word.length())
            return true;
        
        
        
        for(int d=0;d<dr.length;d++){
            
            
            int nr = i+dr[d];
            int nc = j+dc[d];
            
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length && !visited[nr][nc] && 
                board[nr][nc] == word.charAt(index)){
                
                visited[nr][nc] = true;
                if(Util(index+1,board,nr,nc,visited,word))
                    return true;
                visited[nr][nc] = false;        
            }
        
        }
        
        return false;
        
    }

    
    
    public boolean exist(char[][] board, String word) {
        
        
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(word.charAt(0) != board[i][j])
                    continue;
                
                     
                visited[i][j] = true;
                
                if(Util(1,board,i,j,visited,word))
                    return true;
                
                visited[i][j] = false;
            }
        }
        
        return false;
                
    }
}








