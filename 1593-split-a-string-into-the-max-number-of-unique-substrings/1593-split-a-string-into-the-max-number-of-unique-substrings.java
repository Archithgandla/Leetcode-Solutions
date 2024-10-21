class Solution {


    public int Util(int idx,String s,HashMap<String,Integer> hm){
        if(idx == s.length())
            return 0;
        //System.out.println(hm);
        int maxm = Integer.MIN_VALUE;

        for(int i=idx;i<s.length();i++){
            String temp = s.substring(idx,i+1);
            int car = hm.containsKey(temp)?0:1;
            hm.put(temp,1);
            maxm = Math.max(maxm,car+Util(i+1,s,hm));
            if(car == 1)
                hm.remove(temp);
        }

        return maxm;
    }

    public int maxUniqueSplit(String s) {
        return Util(0,s,new HashMap<>());
    }
}







