class Solution {    
    
    
    public long Util(int n,PriorityQueue<Long> pq,HashMap<Long,Integer> hm){

        if(n == 1)
            return pq.poll();

        //System.out.println(pq);

        long top = pq.poll();


        if(!hm.containsKey(top*2)){
            pq.add(top*2);
            hm.put(top*2,1);
        }
        
        if(!hm.containsKey(top*3)){
            pq.add(top*3);
            hm.put(top*3,1);
        }

        if(!hm.containsKey(top*5)){
            pq.add(top*5);
            hm.put(top*5,1);
        }



        return Util(n-1,pq,hm);

    }
    
    
    
    
    
    
    public int nthUglyNumber(int n) {
        
        if(n>=1 && n<=5)
            return n;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add((long)1);

        return (int)Util(n,pq,new HashMap<Long,Integer>());

    }
}





