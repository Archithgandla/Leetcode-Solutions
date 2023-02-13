class Solution {
    public int countOdds(int low, int high) {
        //App-1
        //Run loop from low to high and count odd numbers
        // int count = 0;
        // for(int i=low;i<=high;i++){
        //     if(i%2 != 0)
        //         count+=1;
        // }
        // return count;
        
        //App-2
        if(low%2 == 0 && high%2 == 0)
            return ((high-low)/2);
        else
            return ((high-low)/2)+1;
    }
}