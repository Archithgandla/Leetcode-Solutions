class Solution {
    public double average(int[] salary) {
        int maxi = Integer.MIN_VALUE,mini = Integer.MAX_VALUE;
        double sum = 0;
        
        for(int i:salary){
            maxi = Math.max(maxi,i);
            mini = Math.min(mini,i);
            sum+=i;
        }
        
        return (sum-maxi-mini)/(salary.length-2);
        
    }
}