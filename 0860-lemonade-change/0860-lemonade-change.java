class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int fives = 0,tens = 0,twenties = 0;

        for(int i:bills){

            if(i == 5){
                fives+=1;
                continue;
            }
            else if(i == 10){
                if(fives<=0)
                    return false;
                tens+=1;
                fives-=1;
                continue;
            }


            //System.out.println(fives+" "+tens);
            if(fives<3 && (fives<1 || tens<1))
                return false;

            if(tens>=1 && fives>=1){
                fives-=1;
                tens-=1;                
            }
            else
                fives-=3;
            twenties+=1;
        }
        return true;
        
    }
}