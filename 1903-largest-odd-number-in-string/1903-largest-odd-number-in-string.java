class Solution {
    public String largestOddNumber(String num) {

        int idx = -1;        

        for(int i=0;i<num.length();i++){
            char c = num.charAt(i);
            if((int)(c-'0')%2 != 0)
                idx = i;
        }

        return idx == -1?"":num.substring(0,idx+1);

    }
}