class Solution {
    public int partitionString(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0,i=0,j=0;

        while(j<s.length()){
            if(hm.containsKey(s.charAt(j)) && hm.get(s.charAt(j))>=i){
                count+=1;
                i = j;
                continue;
            }
            hm.put(s.charAt(j),j);
            j+=1;
        }

        count+=1;
        return count;

    }
}