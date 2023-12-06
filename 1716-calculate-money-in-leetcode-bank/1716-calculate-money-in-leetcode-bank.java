class Solution {
    public int totalMoney(int n) {
     
        int numWeeks = n/7;
        int orphanDays = n%7;
        double ans = 0;
        
        int i = 1;
        for(i=1;i<=numWeeks;i++)
            ans = ans+(3.5)*(2*i+(6));
        
        ans = ans+(orphanDays/(double)2)*(2*i+(orphanDays-1));
        
        return (int)ans;
    }
}