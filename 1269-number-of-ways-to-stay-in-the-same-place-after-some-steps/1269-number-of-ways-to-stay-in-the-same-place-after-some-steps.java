class Solution {

    public long Util(int steps,int arrLen,int pos,HashMap<String,Long> hm){

        if(steps == 0)
            return pos == 0?1:0;

        StringBuilder s = new StringBuilder(pos+"$"+steps+"$");
        
        if(hm.containsKey(s.toString()))
            return hm.get(s.toString());
        
        long count = 0;

        if(pos+1<arrLen)
            count = (count + (Util(steps-1,arrLen,pos+1,hm)))%(int)(1e9+7);
        
        if(pos-1>=0)
            count = (count + Util(steps-1,arrLen,pos-1,hm))%(int)(1e9+7);

        count = (count + Util(steps-1,arrLen,pos,hm))%(int)(1e9+7);
        hm.put(s.toString(),count);

        return count;
    }


    public int numWays(int steps, int arrLen) {

        HashMap<String,Long> hm = new HashMap<>();


        return (int)Util(steps,arrLen,0,hm);

    }
}







