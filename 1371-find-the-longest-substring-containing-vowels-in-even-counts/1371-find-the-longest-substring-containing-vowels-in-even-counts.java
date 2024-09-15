class Solution {
    public int findTheLongestSubstring(String s) {
        
        //Refer codestorywithmik video

        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int curr = 0,ans = 0;
        
        for(int i=0;i<s.length();i++){
            
            char c = s.charAt(i);

            if(c == 'a')
                curr = (curr^(1<<0));
            else if(c == 'e')
                curr = (curr^(1<<1));
            else if(c == 'i')
                curr = (curr^(1<<2));
            else if(c == 'o')
                curr = (curr^(1<<3));
            else if(c == 'u')
                curr = (curr^(1<<4));

            if(hm.containsKey(curr))
                ans = Math.max(ans,i-hm.get(curr)+1);
            else
                hm.put(curr,i);
        }
        return ans == 0?0:ans-1;
    }
}







