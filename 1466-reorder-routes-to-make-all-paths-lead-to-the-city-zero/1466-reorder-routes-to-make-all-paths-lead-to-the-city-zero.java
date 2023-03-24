
class Pair{
    int node;
    boolean real;

    Pair(int node,boolean real){
        this.node = node;
        this.real = real;
    }
}


class Solution {
    //Reference : https://www.youtube.com/watch?v=42Z0eaopoZ8
    //Note : It is a n-ary tree  
    
    int DFS(ArrayList<ArrayList<Pair>> Al,int index,int par){
        int count = 0;

        for(Pair p:Al.get(index)){
            if(p.node == par)
                continue;
            
            if(p.real)
                count+=1;

            count+=(DFS(Al,p.node,index));
        }
        return count;
    }
    
    public int minReorder(int n, int[][] connections) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int[] arr:connections){
            adj.get(arr[0]).add(new Pair(arr[1],true));
            adj.get(arr[1]).add(new Pair(arr[0],false));
        }

        return DFS(adj,0,-1);

    }
}