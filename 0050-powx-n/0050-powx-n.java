class Solution {
    //Plain recursion giving TLE
    //So applied dynamic programming using a HashMap,tada
    public double Util(double x, int n,HashMap<Integer,Double> hm){
        if(n == 1)
            return x;
        if(n == 0)
            return 1;
        
        if(hm.containsKey(n))
            return hm.get(n);
        
        double ans;
        if(n%2 == 0){
            ans = Util(x,n/2,hm)*Util(x,n/2,hm);
            hm.put(n,ans);
            return ans;
        }
        ans = Util(x,n/2,hm)*Util(x,(n/2)+1,hm);
        hm.put(n,ans);
        return ans;
    }
    
    public double myPow(double x, int n) {
        HashMap<Integer,Double> hm = new HashMap<>();
        double ans = Util(x,Math.abs(n),hm);
        
        if(n<0)
            return 1/ans;
        return ans;
    }
}