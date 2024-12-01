class Solution {
    public boolean checkIfExist(int[] arr) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i:arr){

            if(hm.containsKey(2*i))
                return true;
            if(i%2 == 0 && hm.containsKey(i/2))
                return true;
            hm.put(i,1);
        }

        return false;
    }
}