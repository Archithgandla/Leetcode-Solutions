class Pair{

    int ns,idx; //ns : Number of soldiers
    Pair(int ns,int idx){
        this.ns = ns;
        this.idx = idx;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.ns != a.ns?b.ns-a.ns:b.idx-a.idx);

        for(int i=0;i<mat.length;i++){
            
            int[] arr = mat[i];
            int count = 0,j=0;

            while(j<arr.length && arr[j] == 1){
                count+=1;
                j+=1;
            }
          
            pq.add(new Pair(count,i));

            if(pq.size()>k)
                pq.poll();
        }

    

        int[] ans = new int[k];
        int i=0;

        while(pq.size()>0){
            ans[k-i-1] = pq.poll().idx;
            i+=1; 
        }

        return ans;

    }
}














