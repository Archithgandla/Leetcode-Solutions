class Pair{
    int freq;
    int time;

    Pair(int freq,int time){
        this.time = time;
        this.freq = freq;
    }
}



class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];

        for(int i=0;i<tasks.length;i++)
            freq[tasks[i]-'A']+=1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Pair> q = new LinkedList<>();

        int counter = 0;

        for(int i:freq){
            if(i!=0)
                pq.add(i);
        }
        
        while(pq.size()>0 || q.size()>0){
            if(q.size()>0 && q.peek().time == counter)
                pq.add(q.poll().freq);
            
            if(pq.size() == 0){
                counter+=1;
                continue;
            }


            int temp = pq.poll();
            counter+=1;

            if(temp-1>0)
                q.add(new Pair(temp-1,counter+n));

        }
        return counter;

    }
}