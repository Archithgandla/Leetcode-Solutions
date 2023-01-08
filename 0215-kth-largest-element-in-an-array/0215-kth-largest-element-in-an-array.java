class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        //Method - 1
        //Using Sort method
        
        //Method - 2
        //using priority Queue
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i:nums){
            pq.add(i);
            
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
        
    }
}