
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
        Queue<Pair> q = new LinkedList<>();
        
        
        for(char c:tasks)
            hm.put(c,hm.getOrDefault(c,0)+1);
              
        for(char c:hm.keySet())
            pq.add(new Pair(hm.get(c),0));
            
        int time = 0;
        
        while(pq.size()>0 || q.size()>0){
            
            if(q.size()>0 && q.peek().avail_time<=time)
                pq.add(q.poll());
            
            if(pq.size()>0){
                
                Pair p = pq.poll();
                
                if(p.freq>1)
                    q.add(new Pair(p.freq-1,time+n+1));
            }
            time+=1;
            
        }
        
        return time;
            
    }
}







