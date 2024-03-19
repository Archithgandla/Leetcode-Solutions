
class Pair{
        
    int freq;
    int avail_time;
        
    Pair(int freq,int avail_time){
        this.freq = freq;
        this.avail_time = avail_time;
    }
        
}


class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char c:tasks)
            hm.put(c,hm.getOrDefault(c,0)+1);
              
        for(char c:hm.keySet())
            pq.add(new Pair(hm.get(c),0));
            
        int time = 0;
        
        while(pq.size()>0){
            
            
            ArrayList<Pair> Al = new ArrayList<>();
            
            while(pq.size()>0){
                
                if(pq.peek().avail_time<=time){
                    Pair p = pq.poll();
                    
                    if(p.freq>1)
                        pq.add(new Pair(p.freq-1,time+n+1));
                    break;
                }
                Al.add(pq.poll());
            }
            
            for(Pair p:Al)
                pq.add(p);
            
            time+=1;
        }
        
        return time;
            
    }
}







