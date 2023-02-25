class Solution {
    public int maxProfit(int[] prices) {
        //Brute force
        //For index i calculate the profit a[j]-a[i] where j>=i and j<n
        //Claculate the maximum among all
        
        
        //Approach-1
        //Calculating the least on the go
        
        int min = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int i:prices){
            min = Math.min(min,i);
            profit = Math.max(profit,i-min);
        }
        return profit;
    }
}