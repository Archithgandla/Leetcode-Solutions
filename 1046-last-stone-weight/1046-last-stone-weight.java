class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i:stones)
            pq.add(i);
        
        while(pq.size()>1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            
            if(stone1 == stone2)
                continue;
            else
                pq.add(stone1-stone2);
        }
        return pq.size()>0?pq.peek():0;
    }
}