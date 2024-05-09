class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        //Approach-1
        //Sort the array
        
        //Approach-2
        //Use priority Queue

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i:happiness){
            pq.add(i);

            if(pq.size()>k)
                pq.poll();
                
        }


        //We need to choose the maximum elements first from queue
        //beacuse as we delay in choose a element
        //its value decreases
        //But if it is a small number ,once it reaches zero
        //it further cannot get reduced
        //but large number's value gets decreased continusly
        //hence choose larger numbers first

        long ans = 0,neg = k-1;

        while(pq.size()>0){
            long add = pq.poll()-neg;
            ans+=(add>=0?add:0);
            neg-=1;
        }
        
        return ans;

    }
}



