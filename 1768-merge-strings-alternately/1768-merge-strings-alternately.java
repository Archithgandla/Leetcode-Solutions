class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int i=0,j=0;

        boolean flag = true;

        while(i<word1.length() && j<word2.length()){
            if(flag){
                str.append(word1.charAt(i));
                i+=1;
            }
            else{
                str.append(word2.charAt(j));
                j+=1;
            }
            flag = !flag;
        }

        while(i<word1.length()){
                str.append(word1.charAt(i));
                i+=1;
        }

        while(j<word2.length()){
                str.append(word2.charAt(j));
                j+=1;
        }

        return str.toString();

    }
}