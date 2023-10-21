class Solution {

    public Boolean DFS(int Node,int[][] adj,
        boolean[] ans,boolean[] visited,boolean[] path_visited){
        
        //System.out.println(Node);
        
        visited[Node] = true;
        path_visited[Node] = true;
        
        for(int i:adj[Node]){
            
            // if(i == Node)
            //     continue;

            if(visited[i] == true && path_visited[i] == true){
                ans[Node] = false;
                continue;
            }

            if(ans[i] == false || 
                (!visited[i] && !DFS(i,adj,ans,visited,path_visited)))
                ans[Node] = false;
        
            
            // if(visited[i])
            //     continue;
            
        }
        
        path_visited[Node] = false;
        return ans[Node];
    }

    public List<Integer> eventualSafeNodes(int[][] adj) {

        int V = adj.length;

        boolean[] visited = new boolean[V];
        boolean[] path_visited = new boolean[V];
        boolean[] ans = new boolean[V];
        
        Arrays.fill(ans,true);
        
        for(int i=0;i<adj.length;i++){

            for(int j:adj[i]){
                if(j == i)
                    ans[i] = false;
            }

        }


        
        for(int i=0;i<V;i++){
            if(visited[i])
                continue;
            DFS(i,adj,ans,visited,path_visited);
        }
        
        System.out.println(Arrays.toString(visited));
        List<Integer> Al = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            if(ans[i])
                Al.add(i);
        }
        
        Collections.sort(Al);
        
        return Al;

    }
}