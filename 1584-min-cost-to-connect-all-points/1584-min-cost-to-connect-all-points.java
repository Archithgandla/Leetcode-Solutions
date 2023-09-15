
//Prims Algorithm
//If along with the minimum cost , the mst is also needed then parent array also need
//to be maintained to extract the tree

class Pair{
    int idx,dist;

    Pair(int idx,int dist){
        this.idx = idx;
        this.dist = dist;
    }
}


class Solution {
    public int minCostConnectPoints(int[][] points) {

        int[][] adj = new int[points.length][points.length];

        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++)
                adj[i][j] = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
        }

        boolean[] visited = new boolean[points.length];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);
        pq.add(new Pair(0,0));
        int ans = 0;


        while(pq.size()>0){

            Pair p = pq.poll();

            if(visited[p.idx])
                continue;

            visited[p.idx] = true;
            ans+=p.dist;

            for(int i=0;i<adj[0].length;i++){
                if(i != p.idx)
                    pq.add(new Pair(i,adj[p.idx][i]));
            }

        }

        return ans;

    }
}






