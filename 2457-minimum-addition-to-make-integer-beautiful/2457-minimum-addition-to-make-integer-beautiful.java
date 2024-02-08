class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        
        //Only the digit sum of a number decreases if it rounded near to
        //its closest 10th or 100th or 1000th or so on
        //anything between num and its 10ths has digit sum<its 10ths
        //similar for all rounded numbers
        //since we are looking for smallest number to added we are moving from
        //10th to 100th to 1000th and so on
        
        
        long fact = 10;

        long add = 0,temp1 = n;

        while(temp1>0){
            add+=(temp1%10);
            temp1/=10;
        }

        if(add<=target)
            return 0;
    
        while(true){

            long temp = n/(long)fact;
            temp = (temp*fact)+fact;

            long res = temp-n;
            long sum = 0;

            while(temp>0){
                sum+=(temp%10);
                temp/=10;
            }

            if(sum<=target)
                return res;
            fact*=10;
        }




    }
}