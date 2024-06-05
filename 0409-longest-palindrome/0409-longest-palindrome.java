class Solution {
    public int longestPalindrome(String s) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
                
        for(char c:s.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);

        
        if(hm.size() == 1)
            return s.length();
        
        int len = 0;
        boolean flag = false;

        for(char c:hm.keySet()){

            if(hm.get(c)%2 == 0){
                len+=hm.get(c);
                continue;
            }
            
            if(!flag)
                len+=1;
            flag = true;
            len+=(hm.get(c)-1);
        }

        return len;
    }
}





