class KthLargest {
    
    //Approach - 1
    //use a arraylist and place the element in the right place(sorted order) whenever an
    //element is to be added
    //and then return kth element
    //Time : o(n) for each insertion space : O(n)
    
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        this.k = k;
        
        for(int i :nums){
            pq.add(i);
            
            if(pq.size()>k)
                pq.poll();
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        
        if(pq.size()>k)
            pq.poll();
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */