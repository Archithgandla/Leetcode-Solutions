class Solution {
    public boolean checkString(String s) {
        
        boolean isBFound = false;

        for(char c:s.toCharArray()){
            if(isBFound && c == 'a')
                return false;
            
            if(c == 'b')
                isBFound = true;
        }

        return true;

    }
}