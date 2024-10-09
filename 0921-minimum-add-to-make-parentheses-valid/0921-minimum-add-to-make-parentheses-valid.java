class Solution {
    public int minAddToMakeValid(String s) {
        
        int open = 0,ans = 0;

        for(char c:s.toCharArray()){
            if(c == '(')
                open+=1;
            else if(c == ')' && open>0)
                open-=1;
            else
                ans+=1;
        }

        return ans+open;

    }
}