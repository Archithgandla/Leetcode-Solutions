class Solution {
    //sliding window
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0,i=0,j=0;
        int[] temp = new int[2];

        while(j<fruits.length){
            if(hm.size()==2 && !hm.containsKey(fruits[j])){

                int idx = 0;        
                for(int k:hm.keySet()){
                    temp[idx] = k;
                    idx+=1;
                }

                if(hm.get(temp[0])>hm.get(temp[1])){
                    i = hm.get(temp[1])+1;
                    hm.remove(temp[1]);
                }
                else{
                    i = hm.get(temp[0])+1;
                    hm.remove(temp[0]);
                }

            }
            hm.put(fruits[j],j);
            ans = Math.max(ans,j-i+1);
            j+=1;
        }
        return ans;
    }
}