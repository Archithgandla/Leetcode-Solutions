class Solution {
    public int countHomogenous(String s) {
        
        long ans = 1,count = 1;

        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i) == s.charAt(i-1)){
                count+=1;
                ans = (ans+count)%(int)(1e9+7);
                continue;
            }
            count = 1;
            ans+=1;
        }

        return (int)ans;

    }
}




