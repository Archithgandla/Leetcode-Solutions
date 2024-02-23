
class Pair{
    
    int dst,cost;
    
    
    Pair(int dst,int cost){
        this.dst = dst;
        this.cost = cost;
    }
    
}




class Solution {
    
    
    
    public int Util(ArrayList<ArrayList<Pair>> adj,int src,int target,int k,int[][] dp){
        
        
        //System.out.println(src);
        
        
        
        if(src == target)
            return 0;
        
        else if(k == 0)
            return Integer.MAX_VALUE;
        
        
        if(dp[src][k] != -1)
            return dp[src][k];
            
        int minm = Integer.MAX_VALUE;
        
        for(Pair p:adj.get(src)){
            
            int temp = Util(adj,p.dst,target,k-1,dp);
            
            if(temp != Integer.MAX_VALUE)
                minm = Math.min(minm,p.cost+temp);
        }
        
        return dp[src][k] = minm;
        
    }
    

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
                
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());
           
        for(int[] flight:flights)
            adj.get(flight[0]).add(new Pair(flight[1],flight[2]));
        
        
        int[][] dp = new int[n+1][k+2];
        
        for(int[] arr:dp)
            Arrays.fill(arr,-1);
        
        int ans = Util(adj,src,dst,k+1,dp);
        
        
        return ans == Integer.MAX_VALUE?-1:ans;
                            
    }
}






