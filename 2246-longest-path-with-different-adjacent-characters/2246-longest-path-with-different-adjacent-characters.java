//Reference : https://www.youtube.com/watch?v=Op6YFcs8R9M
//Secondary Reference : https://www.youtube.com/watch?v=EA8dP63iVP

class Solution {
    int max_value;

    public int DFS(ArrayList<ArrayList<Integer>> adj,int vertex,int parent,String s){

        int maximum = Integer.MIN_VALUE;
        int sec_maximum = Integer.MIN_VALUE;


        for(int i:adj.get(vertex)){
            if(i == parent)
                continue;
            
            int value = DFS(adj,i,vertex,s);

            if(s.charAt(i) == s.charAt(vertex))
                continue;

            if(value>maximum){
                sec_maximum = maximum;
                maximum = value;
            }

            else if(value>sec_maximum)
                sec_maximum = value;

        }

        int max_child = 1+Math.max(maximum,sec_maximum); 
        int convergence = 1+maximum+sec_maximum;
        int only_root = 1;

        max_value = Math.max(max_value,Math.max(only_root,Math.max(max_child,convergence)));

        return Math.max(max_child,only_root);

    }



    public int longestPath(int[] parent, String s) {
        //creating a adjacent matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<parent.length;i++)
            adj.add(new ArrayList<>());
        
        for(int i=1;i<parent.length;i++){
            adj.get(i).add(parent[i]);
            adj.get(parent[i]).add(i);
        }

        max_value = Integer.MIN_VALUE;

        //Calling the function
        DFS(adj,0,-1,s);

        return max_value;

    }
}