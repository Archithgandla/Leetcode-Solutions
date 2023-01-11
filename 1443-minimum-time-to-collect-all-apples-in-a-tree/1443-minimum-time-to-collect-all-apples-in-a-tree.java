class Solution {

//Since it is mentioned as a tree we donot have cycle and it is enough to take parent 
//instead of entire parent array

//     int count;
//     boolean Util(ArrayList<ArrayList<Integer>> adj,List<Boolean> hasApple,int v,int parent){

//         boolean flag = false;
//         if(hasApple.get(v))
//             flag = true;

//         for(int i:adj.get(v)){
//             if(i != parent && Util(adj,hasApple,i,v)){
//                 flag = true;
//                 count+=2;
//             }
//         }
//         return flag;
//     }

//     public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
//         //Constructing a adjacency matrix
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i=0;i<n;i++)
//             adj.add(new ArrayList<>());

//         for(int[] edge:edges){
//             adj.get(edge[0]).add(edge[1]);
//             adj.get(edge[1]).add(edge[0]);
//         }
//        // System.out.println(adj);

//         count = 0;
//         Util(adj,hasApple,0,-1);

//         return count;
//     }
    
    
    //Better Approach
    //Without using global variables
    //Referecne : https://www.youtube.com/watch?v=qSBvKlUq0xo
    
    int Util(ArrayList<ArrayList<Integer>> adj,int v,int parent,List<Boolean> hasApple){
        int count = 0;
        
        for(int i:adj.get(v)){
            if(i == parent)
                continue;
            
            int from_child = Util(adj,i,v,hasApple);
            
            if(hasApple.get(i) == true || from_child>0){
                count+=from_child;
                count+=2;
            }
                
        }
        return count;
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //Constructing a adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return Util(adj,0,-1,hasApple);
        
    }
        

}