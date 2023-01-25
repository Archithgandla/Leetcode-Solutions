//It can also be solved using BFS and DFS
//Reference : https://www.youtube.com/watch?v=Vn-voe1XNtQ


class Pair{
    int distance;
    int vertice;

    Pair(int vertice,int distance){
        this.vertice = vertice;
        this.distance = distance;
    }

}

class Solution {

    public void Djikstra(int[] edges,int[] distances,int source){
        
        for(int i=0;i<distances.length;i++)
            distances[i] = Integer.MAX_VALUE;

        distances[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        pq.add(new Pair(source,0));

        while(pq.size()>0){
            Pair temp = pq.poll();
            int v = temp.vertice;

            if(edges[v] != -1 && distances[v]+1<distances[edges[v]]){
                distances[edges[v]] = distances[v]+1;
                pq.add(new Pair(edges[v],distances[v]+1));
            }
        }

    }


    public int closestMeetingNode(int[] edges, int node1, int node2) {
        //Approach - 1
        //Use djikstra algortihm to find shortest distances to all the nodes
        //from node1 and node2
        //Now compare the distances to find the answer

        int[] distance1 = new int[edges.length];
        int[] distance2 = new int[edges.length];

        Djikstra(edges,distance1,node1);
        Djikstra(edges,distance2,node2); 
        int ans = -1,min = Integer.MAX_VALUE;


        //Comparing distance arrays of two node1 obtained from djikstra algorithms
        for(int i=0;i<distance1.length;i++){
            if(distance1[i] != Integer.MAX_VALUE && distance2[i] != Integer.MAX_VALUE){
                int maxi = Math.max(distance1[i],distance2[i]);

                if(maxi<min){
                    min = maxi;
                    ans = i;
                }
            }
        }


        return ans;
    }
}