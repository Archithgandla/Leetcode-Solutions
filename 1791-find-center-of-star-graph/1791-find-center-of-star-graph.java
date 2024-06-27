class Solution {
    public int findCenter(int[][] edges) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int[] edge:edges){
            hm.put(edge[0],hm.getOrDefault(edge[0],0)+1);
            hm.put(edge[1],hm.getOrDefault(edge[1],0)+1);
        }
        
        System.out.println(hm);
        
        for(int k:hm.keySet()){
            if(hm.get(k) == edges.length)
                return k;
        }
        
        return -1;
    }
}






