


//Note : It is allowed for a path to contain the same road multiple times,
//Since a node can be vsited multiple times
//So even if a node is not leading to destination but it had minm distance
//it can be considered in our answer since a node can be visited multiple times

class Pair{
    int v,dist;
    
    Pair(int v,int dist){
        this.v = v;
        this.dist = dist;
    }
}




class Solution {
    

    int Util(ArrayList<ArrayList<Pair>> Al,int index,
    boolean[] visited){
        
        //System.out.println(index);
        visited[index] = true;
        int min = Integer.MAX_VALUE;
               
        for(Pair p:Al.get(index)){
            
            min = Math.min(min,p.dist);
            
            if(!visited[p.v]){
                min = Math.min(min,Util(Al,p.v,visited));
            }
        }
        
        return min;
    }
    
    
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> Al = new ArrayList<>();

                
        for(int i=0;i<=n;i++)
            Al.add(new ArrayList<>());
        
        for(int[] arr:roads){
            Al.get(arr[0]).add(new Pair(arr[1],arr[2]));
            Al.get(arr[1]).add(new Pair(arr[0],arr[2]));
        }

        
        return Util(Al,1,new boolean[n+1]);
                
    }
}