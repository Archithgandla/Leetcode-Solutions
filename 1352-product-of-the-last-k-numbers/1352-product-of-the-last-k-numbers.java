class ProductOfNumbers {

    ArrayList<Integer> Al;
    int latestZeroIndex;

    public ProductOfNumbers() {
        Al = new ArrayList<>();
        latestZeroIndex = -1;
    }
    
    public void add(int num) {
        
        if(Al.size() == 0 || (Al.size()>0 && Al.get(Al.size()-1) == 0))
            Al.add(num);
        else
            Al.add(num*Al.get(Al.size()-1));

        //System.out.println(Al);

        if(num == 0)
            latestZeroIndex = Al.size()-1;
    }
    
    public int getProduct(int k) {

        //System.out.println(k);

        if((Al.size()-latestZeroIndex)<=k)
            return 0;
        int ans = Al.get(Al.size()-1);

        if(Al.size()-k-1>=0 && Al.get(Al.size()-k-1) != 0)
            ans/=Al.get(Al.size()-k-1);

        //System.out.println(ans);
        return ans;

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */