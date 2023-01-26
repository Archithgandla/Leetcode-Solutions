class Solution {
    public int strStr(String haystack, String needle) {
        
        int i=0;
        
        while(i<=haystack.length() - needle.length()){
            
            if(haystack.charAt(i) == needle.charAt(0) && 
               haystack.substring(i,i+needle.length()).equals(needle))
                return i;
            i+=1;
        }
        
        return -1;
    }
}