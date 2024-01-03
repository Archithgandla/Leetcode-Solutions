class Solution {
    public int numberOfBeams(String[] bank) {

        int prev = 0,count = 0;


        for(String str:bank){

            int temp = 0;

            for(char c:str.toCharArray())
                temp+=(c == '1'?1:0);

            count+=(temp*prev);
            prev = (temp != 0 ?temp:prev);
        }

        return count;
    }
}










