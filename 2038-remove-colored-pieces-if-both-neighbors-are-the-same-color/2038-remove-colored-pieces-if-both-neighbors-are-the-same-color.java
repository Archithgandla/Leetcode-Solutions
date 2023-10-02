class Solution {
    public boolean winnerOfGame(String colors) {

        if(colors.length() == 1)
            return false;


        int alice = 0,bob = 0,i = 0;

        while(i<colors.length()){

            int count = 0,temp = i+1;
            char c = colors.charAt(i);

            while(temp<colors.length() && colors.charAt(temp) == c){
                count+=1;
                temp+=1;
            }  

            if(c == 'A')
                alice+=(count == 0?0:count-1);
            else
                bob+=(count == 0?0:count-1);
            i = temp;
        }

        // System.out.println(alice+" "+bob);

        return alice>bob;
    }
}







