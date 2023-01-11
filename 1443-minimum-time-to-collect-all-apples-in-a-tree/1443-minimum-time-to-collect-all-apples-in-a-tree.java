class Solution {

    int count;
    boolean Util(ArrayList<ArrayList<Integer>> adj,List<Boolean> hasApple,int v,boolean[] visited){

        boolean flag = false;
        if(hasApple.get(v))
            flag = true;
        visited[v] = true;

        for(int i:adj.get(v)){
            if(visited[i] != true && Util(adj,hasApple,i,visited)){
                flag = true;
                count+=2;
            }
        }
        return flag;
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
       // System.out.println(adj);
        boolean[] visited = new boolean[n];

        count = 0;
        visited[0] = true;
        Util(adj,hasApple,0,visited);

        return count;
    }
}