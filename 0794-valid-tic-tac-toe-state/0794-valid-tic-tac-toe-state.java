class Solution {

    boolean areSameBoards(char[][] curr,char[][] board){
        
        for(int i=0;i<curr.length;i++){
            for(int j=0;j<curr[0].length;j++){
                if(curr[i][j] != board[i][j])
                    return false;
            }
        }
        return true;
    }

    boolean winnerExists(char[][] curr){
        

        //checking rows and columns
        for(int i=0;i<curr.length;i++){
            if((curr[i][0] == curr[i][1] && curr[i][1] == curr[i][2] && curr[i][1] != ' ') || 
            (curr[0][i] == curr[1][i] && curr[1][i] == curr[2][i] && curr[i][1] != ' '))
                return true;
        }
        if((curr[0][0] == curr[1][1]) && (curr[1][1] == curr[2][2]) && curr[1][1] != ' ')
            return true;
        if((curr[0][2] == curr[1][1]) && (curr[1][1] == curr[2][0]) && curr[1][1] != ' ')
            return true;
        return false;
    }

    public boolean Util(char[][] curr,char[][] board,boolean turn){

        if(areSameBoards(curr,board))
            return true;

        if(winnerExists(curr))
            return false;

        char mark = turn?'X':'O';

        for(int i=0;i<curr.length;i++){
            for(int j=0;j<curr[0].length;j++){
                if(curr[i][j] != ' ')
                    continue;
                
                curr[i][j] = mark;

                if(Util(curr,board,!turn))
                    return true;

                curr[i][j] = ' ';
            }
        }
        return false;
    }

    public boolean validTicTacToe(String[] board) {

        char[][] temp = new char[board.length][board[0].length()];

        for(int i=0;i<board.length;i++){
            String s = board[i];
            for(int j=0;j<s.length();j++)
                temp[i][j] = s.charAt(j);
        }

        char[][] curr = new char[3][3];

        for(char[] sep:curr)
            Arrays.fill(sep,' ');

        return Util(curr,temp,true);
    }
}











