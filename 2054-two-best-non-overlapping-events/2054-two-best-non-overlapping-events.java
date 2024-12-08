class Pair{
    int end,maxm;
    Pair(int end,int maxm){
        this.end = end;
        this.maxm = maxm;
    }
}

class Solution {
    public int BS(ArrayList<Pair> Al,int ub){

        int low = 0,high = Al.size()-1;
        int mid = low+(high-low)/2,maxm = 0;

        while(low<=high){

            if(Al.get(mid).end == ub)
                return Al.get(mid).maxm;
            else if(Al.get(mid).end>ub)
                high = mid-1;
            else if(Al.get(mid).end<ub){
                maxm = Math.max(maxm,Al.get(mid).maxm);
                low = mid+1;
            }
            mid = low+(high-low)/2;
        }

        //System.out.println(ub+" "+maxm);
        return maxm;
    }

    public int maxTwoEvents(int[][] events) { 
        Arrays.sort(events,(a,b) -> a[1]-b[1]);
        ArrayList<Pair> Al = new ArrayList<>();        

        int maxm = Integer.MIN_VALUE;

        for(int[] event:events){
            //int bef = (Al.size()>0 && Al.get(Al.size()-1).end<event[0])?Al.get(Al.size()-1).maxm:0;
            int bef = BS(Al,event[0]-1);

            maxm = Math.max(maxm,event[2]+bef);
        
            if(Al.size()>0 && Al.get(Al.size()-1).end == event[1]){
                Al.get(Al.size()-1).maxm = Math.max(Al.get(Al.size()-1).maxm,event[2]);
                continue;
            }
            
            Pair p = new Pair(event[1],event[2]);

            if(Al.size()>0)
                p.maxm = Math.max(event[2],Al.get(Al.size()-1).maxm);

            Al.add(p);
            //System.out.println(Arrays.toString(event)+" "+maxm);
        }
        return maxm;
    }
}




