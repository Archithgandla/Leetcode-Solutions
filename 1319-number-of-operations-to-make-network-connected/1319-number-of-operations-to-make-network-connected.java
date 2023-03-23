class Solution {
    
    void DFS(ArrayList<ArrayList<Integer>> Al,boolean[] visited,int index){
        
        visited[index] = true;

        for(int v:Al.get(index)){
            if(!visited[v]){
                DFS(Al,visited,v);
            }
        }

    }
    
    
    
    
    public int makeConnected(int n, int[][] connections) {

        if(connections.length<n-1)
            return -1;

        int connected_components = 0;
        ArrayList<ArrayList<Integer>> Al = new ArrayList<>();

        for(int i=0;i<n;i++)
            Al.add(new ArrayList<>());

        for(int[] arr:connections){
            Al.get(arr[0]).add(arr[1]);
            Al.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                connected_components+=1;
                DFS(Al,visited,i);
            }
        }

        //int no_of_edges = connections.length;
        return connected_components-1;

    }
}