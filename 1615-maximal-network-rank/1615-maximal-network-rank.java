class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        //consider all the pairs and for each node in the graph
        //sum up the degree of both the nodes and subtract the 
        //common edge if exists

        //It can also be solved without extra space
        //but the time complexity might increase
        //since in nested loop for each node we might have to
        //count degree so it becomes n^3 time complexity

        int[][] adj = new int[n][n];
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int[] arr:roads){
            hm.put(arr[0],hm.getOrDefault(arr[0],0)+1);
            hm.put(arr[1],hm.getOrDefault(arr[1],0)+1);
            adj[arr[0]][arr[1]] = 1;
            adj[arr[1]][arr[0]] = 1;
        }

        //System.out.println(hm);
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                if(j == i)
                    continue;

                maxi = Math.max(maxi,hm.getOrDefault(i,0)+hm.getOrDefault(j,0)-adj[i][j]);
            }
        }
        return maxi;
    }
}