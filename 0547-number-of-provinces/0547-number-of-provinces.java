class Solution {
    
        
    public int findCircleNum(int[][] isConnected) {
       //DFS Very easy
       //BFS
       
        
        ArrayList<ArrayList<Integer>> Al = new ArrayList<>();
        
        for(int i=0;i<isConnected.length;i++)
            Al.add(new ArrayList<>());
        
        
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j] == 1){
                    Al.get(i).add(j);
                    Al.get(j).add(i);
                }
            }
        }
        
        
        
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        
        
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                
                q.add(i);
                visited[i] = true;
                count+=1;
                
                while(q.size()>0){
                    int temp = q.poll();
                    
                    for(int v:Al.get(temp)){
                        if(!visited[v]){
                            visited[v] = true;
                            q.add(v);
                        }
                    }
                }
                
                
            }    
        }
        return count;
        
    }
}