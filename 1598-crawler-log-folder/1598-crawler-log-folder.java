class Solution {
    public int minOperations(String[] logs) {


        int count = 0;

        for(String str:logs){

            if(str.equals("./"))
                continue;
            else if(str.equals("../")){
                count = Math.max(count-1,0);
                continue;
            }
            count+=1;       
        }

        return count;


    }
}