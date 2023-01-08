class Pair{
    int[] point;
    int distance;
    
    Pair(int[] point,int distance){
        this.point = point;
        this.distance = distance;
    }
}



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.distance-a.distance);
        
        for(int[] arr:points){
            pq.add(new Pair(arr,(arr[0]*arr[0])+(arr[1]*arr[1])));
            
            if(pq.size()>k)
                pq.poll();
        }
        
        int[][] ans = new int[pq.size()][2];
        
        for(int i=0;i<ans.length;i++)
            ans[i] = pq.poll().point;
        return ans;
    }
}