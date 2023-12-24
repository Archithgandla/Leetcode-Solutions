class Solution {
    public int minOperations(String s) {
        
        char prev = s.charAt(0);
        int count1 = 0,count2 = 0;
        
        
        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i) != prev)
                prev = s.charAt(i);
            else{
                prev = s.charAt(i) == '0'?'1':'0';
                count1+=1;
            }
        }
        
        prev = s.charAt(0) == '0'?'1':'0';
        count2+=1;
        
        for(int i=1;i<s.length();i++){
            
            if(s.charAt(i) != prev)
                prev = s.charAt(i);
            else{
                prev = s.charAt(i) == '0'?'1':'0';
                count2+=1;
            }
        }
        
        
        
        return Math.min(count1,count2);
        
    }
}