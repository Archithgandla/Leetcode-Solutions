class Solution {
    public int firstUniqChar(String s) {
        
        //Approach-1
        //O(N^2)
        //Nested Loop

        //Approach-2

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);

            if(hm.containsKey(c)){
                hm.put(c,-1);
                continue;
            }
            hm.put(c,i);
        }

        int minm = Integer.MAX_VALUE;

        for(char c:hm.keySet()){
            if(hm.get(c) == -1)
                continue;
            minm = Math.min(minm,hm.get(c));
        }

        return minm != Integer.MAX_VALUE?minm:-1;



    }
}