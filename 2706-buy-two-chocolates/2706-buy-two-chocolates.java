class Solution {
    public int buyChoco(int[] prices, int money) {
        
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        
        for(int i:prices){
            
            if(i<=min1){
                min2 = min1;
                min1 = i;
            }
            else if(i<min2)
                min2  = i;
        }
        
        if(min1+min2<=money)
            return money-(min1+min2);
        return money;
    }

}