class Solution {
    public boolean backspaceCompare(String s, String t) {

        StringBuilder str1 = new StringBuilder("");
        StringBuilder str2 = new StringBuilder("");

        for(char c:s.toCharArray()){
            if(c == '#' && str1.length()>0)
                str1.deleteCharAt(str1.length()-1);
            
            else if(c != '#')
                str1.append(c);
        }

        for(char c:t.toCharArray()){
            if(c == '#' && str2.length()>0)
                str2.deleteCharAt(str2.length()-1);
            
            else if(c != '#')
                str2.append(c);
        }

        if(str1.length() != str2.length())
            return false;

        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i))
                return false;
        }

        return true;

    }
}

