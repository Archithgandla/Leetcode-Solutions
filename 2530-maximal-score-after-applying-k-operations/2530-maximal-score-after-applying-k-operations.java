class Solution {
    public long maxKelements(int[] nums, int k) {
        
        long ans = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(long i:nums)
            pq.add(i);
        
        while(k>0){
            long temp = pq.poll();
            ans+=temp;
            pq.add(temp%3 == 0?temp/3:(temp/3)+1);
            k-=1;
        }
        
        return ans;
        
    }
}





