class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        char[] sa = new char[26];
        char[] ta = new char[26];
        
        for(char c:s.toCharArray())
            sa[c-'a']+=1;
        for(char c:t.toCharArray())
            ta[c-'a']+=1;;
        
        
        
        for(int i=0;i<26;i++){
            if(sa[i] != ta[i])
                return false;
        }
        
        return true;
    }
}