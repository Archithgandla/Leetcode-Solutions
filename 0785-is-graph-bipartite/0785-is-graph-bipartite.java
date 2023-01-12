class Solution {
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int color,int v){
        
        visited[v] = color;
        
        for(int i:adj.get(v)){
            if(visited[i] == -1){
                int newColor = color == 0?1:0;
                
                if(dfs(adj,visited,newColor,i) == false)
                    return false;
                
            }else if(visited[i] == color){
                return false;
            }
        }
        
        return true;     
    }
    
    
    public boolean isBipartite(int[][] graph) {
        //creating a adjacent matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<graph.length;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++)
                adj.get(i).add(graph[i][j]);    
        }
        
        
        
        int[] colors = new int[graph.length];
        
        for(int i=0;i<graph.length;i++)
            colors[i] = -1;
        
        for(int i=0;i<graph.length;i++){
            if(colors[i] == -1){
                if(dfs(adj,colors,0,i) == false)
                    return false;
            }
        }
        return true;
    }
}