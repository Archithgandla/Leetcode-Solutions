class MyHashSet {
    
    HashMap<Integer,Boolean> hm;
    public MyHashSet() {
        hm = new HashMap<>();
    }
    
    public void add(int key) {
        if(!hm.containsKey(key))
            hm.put(key,true);
    }
    
    public void remove(int key) {
        if(!hm.containsKey(key))
            return;
        hm.remove(key);
    }
    
    public boolean contains(int key) {
        return hm.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */