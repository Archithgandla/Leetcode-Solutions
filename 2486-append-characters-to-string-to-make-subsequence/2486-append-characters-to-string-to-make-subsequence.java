class Solution {
    public int appendCharacters(String s, String t) {
        
        int idx = 0;

        for(int i=0;i<s.length() && idx<t.length();i++){

            if(s.charAt(i) != t.charAt(idx))
                continue;
            idx+=1;
        }


        return t.length()-idx;

    }
}



