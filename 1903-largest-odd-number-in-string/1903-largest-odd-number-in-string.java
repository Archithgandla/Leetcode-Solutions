class Solution {
    public String largestOddNumber(String num) {

        int idx = -1;        

        for(int i=num.length()-1;i>=0;i--){
            char c = num.charAt(i);
            if((int)(c-'0')%2 != 0){
                idx = i;
                break;
            }
        }

        return idx == -1?"":num.substring(0,idx+1);

    }
}