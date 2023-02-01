class Solution {
    public int lengthOfLastWord(String s) {
        
        for(int i=s.length()-1;i>=0;i--){
            if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z')){
                
                int j=i;
                while(j>=0 && s.charAt(j) != ' ')
                    j-=1;    
                return i-j;
            }    
        }
        return -1;
    }
}