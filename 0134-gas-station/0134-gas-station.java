class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        
        //Consider that there are five stations
        //fuel+=(gas[i]-cost[i]);
        //We started at index 0 and at 2 fuel came out to be negative
        //That means we cannot move any further
        //If we have started from index 2 then we would have stopped even before beacuse we have moving forward only extra fuel+present >0
        //That means there is less fuel after first stations
        //So now we need to find subarray such that whose excess is greater than or equal to previous subarray's deficiecy
        
        int fuel = 0,req = 0,start = 0;
        for(int i=0;i<gas.length;i++){
            fuel+=(gas[i]-cost[i]);

            if(fuel<0){
                req+=fuel;
                fuel=0;
                start = i+1;
            }
        }

        if(fuel<-req)
            return -1;

        return start;
    }
}