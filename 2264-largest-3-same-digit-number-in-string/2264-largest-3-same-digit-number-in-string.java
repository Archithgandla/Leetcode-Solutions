class Solution {
    public String largestGoodInteger(String num) {
        
        String ans = "";
        int ref = Integer.MIN_VALUE;
        
        for(int i=0;i<num.length();i++){
            
            if(i+2<num.length() && num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)
              && (int)(num.charAt(i)-'0')>ref){
                
                ref = (int)(num.charAt(i)-'0');
                ans = num.substring(i,i+3);
            }
            
        }
        
        return ans;
    }
}