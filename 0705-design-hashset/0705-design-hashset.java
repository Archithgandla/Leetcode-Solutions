class MyHashSet {
    
    int[] arr;
    public MyHashSet() {
        arr = new int[(int)1e6+1];
        Arrays.fill(arr,-1);
    }
    
    public void add(int key) {
        arr[key] = 1;
    }
    
    public void remove(int key) {
        arr[key] = -1;
    }
    
    public boolean contains(int key) {
        return arr[key] == -1?false:true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */