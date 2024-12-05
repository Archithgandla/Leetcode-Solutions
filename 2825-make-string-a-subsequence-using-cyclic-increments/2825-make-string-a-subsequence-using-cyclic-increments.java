class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {

        int i=0,j=0;

        while(i<str1.length() && j<str2.length()){

            int c1 = (int)(str1.charAt(i)-'a'),c2 = (int)(str2.charAt(j)-'a'); 

            if(c1 == c2 || (c1+1)%26 == c2){
                i+=1;
                j+=1;
            }
            else
                i+=1;
        }

        return j == str2.length();

    }
}








