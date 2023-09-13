//For O(N) Approach refer 
//https://www.youtube.com/watch?v=YUT13Koh5Jg


//Using a min heap to store children according to their ratings
//Since it is a min heap
//First children with less priority come out of heap
//we assign them with a priority
//Before assigning candies we check both left and right 
//If the neighbour has less priority then the neighbour would have come out of heap earlier itself
//hence the less priority would have assigned candies already
//If the neighbour has more rating than current then we dont care and just assign 1
//so if one of the neighbours with lesser priority is found then just assign +1 candies than the 
//lesser priority neighbour


//This idea to use min pq came because
//I tried assigning candies from left to right but the right candies are not yet assigned yet
//hence we cannot assign candies to our current index 
//So if we use min pq the the lesser rating or priority neighbours are already assigned with candies
//so we just +1 to our current index
//If the neighbour has more rating than current then we dont care and just assign 1

class Pair{
    int rating,index;

    Pair(int rating,int index){
        this.rating = rating;
        this.index = index;
    }
}


class Solution {
    public int candy(int[] ratings) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.rating-b.rating);
        int[] candies = new int[ratings.length];    
        Arrays.fill(candies,-1);
        int used = 0;

        for(int i=0;i<ratings.length;i++)
            pq.add(new Pair(ratings[i],i));


        while(pq.size()>0){
            
            int required = 1;
            Pair p = pq.poll();

            if(p.index-1>=0 && ratings[p.index]>ratings[p.index-1])
                required = Math.max(candies[p.index-1]+1,required);
            
            if(p.index+1<ratings.length && ratings[p.index]>ratings[p.index+1])
                required = Math.max(candies[p.index+1]+1,required);
            
            candies[p.index] = required;
            //System.out.println(required);
            used+=required;

        }
        return used;

    }
}










