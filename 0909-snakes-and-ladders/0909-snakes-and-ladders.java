//For BFS use template by codestorywithMIK
//Reference : https://www.youtube.com/watch?v=26IT3FYm5h8

// class Pair{
//     int element;
//     int level;

//     Pair(int element,int level){
//         this.element = element;
//         this.level = level;
//     }
// }


// class Solution {

//     int findCoordinates(int num,int n,int[][] board){
//         //Calculating row index
//         int index_from_top = (num-1)/n;
//         int index_from_bottom = n-1 - ((num-1)/n);

//         //Calculating column index
        
//         if(n%2 == 0 && (index_from_bottom)%2 == 0)
//             return board[index_from_bottom][n-1-((num-1)%n)];
//         return board[index_from_bottom][(num-1)%n]; 
//     }


//     public int snakesAndLadders(int[][] board) {
//         //It can be solved using DFS
//         //But takes more time

//         //Shortest path problems can be preferably solved using BFS
//         //Level by Level
//         int n = board.length;
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(0,0));
//         boolean[] visited = new boolean[n*n+1];
//         visited[1] = true;

//         while(q.size()>0){
//             Pair temp = q.poll();
//             int curr = temp.element;

//             if(curr == n*n)
//                 return temp.level;

//             for(int i=1;i<=6;i++){
//                 if(curr+i>(n*n))
//                     break;

//                 if(visited[curr+i])
//                     continue;

//                 visited[curr+i] = true;
//                 if(findCoordinates(curr+i,n,board) != -1)
//                     q.add(new Pair(findCoordinates(curr+i,n,board),temp.level+1));
//                 else
//                     q.add(new Pair(curr+i,temp.level+1));
//             }
//         }
//         return -1;
//     }
// }




class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        Map<Integer,Integer>hm=new HashMap<>();
        hm.put(1,0);//as we are starting from 1st position so we are adding 1 and the number of steps taken are 0
        Queue<Integer>q=new LinkedList<>();
        q.add(1);//for starting bfs
        while(!q.isEmpty()){
            int p=q.poll();
            if(p==n*n) return hm.get(p);
            for(int i=p+1;i<=Math.min(p+6,n*n);i++){
                int next=check(i,n);//getting the next most suitable position to jump
                int row=next/n,col=next%n;
                int ns=board[row][col]==-1?i:board[row][col];
                /*normal BFS*/
                if(!hm.containsKey(ns)){
                    hm.put(ns,hm.get(p)+1);
                    q.offer(ns);
                }
            }
        }
        return -1;
    }
    public static int check(int i,int n){
        int q=(i-1)/n,r=(i-1)%n;
        int row=n-1-q;
        int col=row%2!=n%2?r:n-1-r;
        return row*n+col;
    }
}
