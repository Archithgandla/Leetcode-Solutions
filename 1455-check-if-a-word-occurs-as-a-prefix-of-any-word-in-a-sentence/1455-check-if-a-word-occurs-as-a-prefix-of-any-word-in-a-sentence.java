class Solution {

    public boolean isPrefix(StringBuilder word,String target){

        int i=0,j=0;
        while(i<word.length() && j<target.length()){
            if(word.charAt(i) != target.charAt(j))
                return false;
            i+=1;
            j+=1;
        }
        if(j == target.length())
            return true;
        return false;
    }

    public int isPrefixOfWord(String sentence, String searchWord) {

        StringBuilder word = new StringBuilder("");
        int idx = 1;

        for(char c:sentence.toCharArray()){
            if(c != ' '){
                word.append(c);
                continue;
            }
            if(isPrefix(word,searchWord))
                return idx;
            idx+=1;
            word = new StringBuilder("");
        }

        if(isPrefix(word,searchWord))
            return idx;


        return -1;
    }
}






