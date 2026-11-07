
class Pair{

    int idx,w,time;

    Pair(int idx,int w,int time){
        this.idx = idx;
        this.w = w;
        this.time = time;
    }

}

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<Pair> avail = new PriorityQueue<>((a,b) -> a.w == b.w ? a.idx-b.idx : a.w-b.w);
        PriorityQueue<Pair> reser = new PriorityQueue<>((a,b) -> a.time-b.time);
        int[] ans = new int[tasks.length];

        int i = 0,t = 0;


        for(int j=0;j<servers.length;j++)
            avail.add(new Pair(j,servers[j],0));


        while(i<tasks.length){

            while(reser.size()>0  && reser.peek().time<=t)
                avail.add(reser.poll());

            if(avail.size()<=0){
                t = reser.peek().time;
                continue;
            }

            Pair p = avail.poll();
            ans[i] = p.idx; 

            p.time = t+tasks[i];
            reser.add(p);

            i+=1;

            if(t<i)
                t+=1;
        }

        return ans;

    }
}


