class Solution {
    public int maxCoins(int[] piles) {


        //No matter how the piles are chosen in sets of 3
        //The maximum pile is always gone
        //So to minimimze the loss there is only one way
        //i.e make sure that pile picked by bob is always minimum so that loss is miminum

        Arrays.sort(piles);
        int count = piles.length/3,idx = piles.length-2;

        int ans = 0;
        while(count>0){
            ans+=piles[idx];
            count-=1;
            idx-=2;
        }

        return ans;

    }
}