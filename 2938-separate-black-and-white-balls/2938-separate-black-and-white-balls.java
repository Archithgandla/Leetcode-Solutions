class Solution {
    public long minimumSteps(String s) {
        
        long count = 0,ref = -1;

        for(int i=s.length()-1;i>=0;i--){

            if(s.charAt(i) == '0' && ref  == -1)
                ref = i;
            else if(s.charAt(i) == '1' && ref  != -1){
                count+=(ref-i);
                ref-=1;
            }
        }
        
        return count;
    }
}


