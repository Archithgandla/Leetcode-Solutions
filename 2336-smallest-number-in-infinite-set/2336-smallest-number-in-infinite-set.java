class SmallestInfiniteSet {
    HashMap<Integer,Integer> hm;
    int smallest;
    public SmallestInfiniteSet() {
        hm = new HashMap<>();
        smallest = 1;
    }
    
    public int popSmallest() {
        hm.put(smallest,1);
        int temp = smallest;
        int ans = temp;

        while(hm.containsKey(temp))
            temp+=1;
        smallest = temp;
        return ans;
    }
    
    public void addBack(int num) {
        if(hm.containsKey(num))
            hm.remove(num);
        smallest = num<smallest?num:smallest;
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */