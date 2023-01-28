//Reference : https://www.youtube.com/watch?v=Lh0PXb3Hqik



class SummaryRanges {
    
    TreeMap<Integer,Integer> hm;
    boolean change = false;
    //int[][] ans = new int[][];
    public SummaryRanges() {
        hm = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if(!hm.containsKey(value)){
            hm.put(value,1);
            change = true;
        }
    }
    
    public int[][] getIntervals() {
        
        // if(!change)
        //     return 
        
        ArrayList<ArrayList<Integer>> Al = new ArrayList<>(); 
        int left = -1,right = -1;
        boolean flag = true;
        
        for(int i:hm.keySet()){
            if(flag){
                left = i;
                right = i;
                flag = false;
                continue;
            }
            
            if(i-right == 1)
                right = i;    
            else{
                //Adding here
                
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(left);
                arr.add(right);
                
                Al.add(arr);
                left = i;
                right = i;
            }
            
        }
                ArrayList<Integer> ar = new ArrayList<>();
                ar.add(left);
                ar.add(right);
                
                Al.add(ar);
        
        
        int[][] ans = new int[Al.size()][2];
        
        int i=0;
        for(ArrayList<Integer> arr:Al){
            ans[i][0] = Al.get(i).get(0);
            ans[i][1] = Al.get(i).get(1);
            i+=1;
        }
        change = true;
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */