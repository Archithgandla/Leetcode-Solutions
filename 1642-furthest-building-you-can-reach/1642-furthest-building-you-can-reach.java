class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        //Approach-1
        //It is failing due to 
        // [1,5,1,2,3,4,10000]
        // 4
        // 1
        //This test case

        // PriorityQueue<Integer> pq = new PriorityQueue<>();


        // for(int i=1;i<heights.length;i++){
            
        //     if(heights[i]<=heights[i-1])
        //         continue;
            
        //     pq.add(heights[i]-heights[i-1]);

        //     if(pq.size()>ladders)
        //         pq.poll();
        // }


        // HashMap<Integer,Integer> hm = new HashMap<>();

        // while(pq.size()>0){
        //     hm.put(pq.peek(),hm.getOrDefault(pq.peek(),0)+1);
        //     pq.poll();
        // }

        // for(int i=1;i<heights.length;i++){

        //     if(heights[i]<=heights[i-1])
        //         continue;

        //     if(ladders>0 && hm.containsKey(heights[i]-heights[i-1])){

        //         if(hm.get(heights[i]-heights[i-1])>1)
        //             hm.put(heights[i]-heights[i-1],hm.get(heights[i]-heights[i-1])-1);
        //         else
        //             hm.remove(heights[i]-heights[i-1]);
        //         ladders-=1;
        //         continue;
        //     }

        //     else if(bricks>=heights[i]-heights[i-1])
        //         bricks-=(heights[i]-heights[i-1]);

        //     else if(ladders>0) 
        //         ladders-=1;
        //     else
        //         return i-1;
        // }

        // return heights.length-1;

        //Approach-2
        //refer codestorywithmik
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int i=1;i<heights.length;i++){
            
            if(heights[i]<=heights[i-1])
                continue;
            
            if(bricks>=heights[i]-heights[i-1]){
                bricks-=(heights[i]-heights[i-1]);
                pq.add(heights[i]-heights[i-1]);
            }
            else if(ladders>0){
                
                int diff = heights[i]-heights[i-1];

                if(pq.size()>0 && pq.peek()>=diff){

                    int got = pq.poll();
                    bricks-=(heights[i]-heights[i-1]);
                    bricks+=(got);
                    pq.add(heights[i]-heights[i-1]);
            
                }

                ladders-=1;

            }

            else
                return i-1;

        }


        return heights.length-1;

    }
}



