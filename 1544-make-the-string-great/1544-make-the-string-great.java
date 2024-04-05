class Solution {
    public String makeGood(String s) {
        
        StringBuilder str = new StringBuilder("");
        
        for(char c:s.toCharArray()){
                
            if(str.length() != 0 && (Character.toLowerCase(c) == Character.toLowerCase(str.charAt(str.length()-1)) &&
                                    c != str.charAt(str.length()-1))){
                
                str.deleteCharAt(str.length()-1);
                continue;
            }
            
            str.append(c);
            //System.out.println(str);
            
        }
        
        return str.toString();
    
    }
}



