class Solution {

    HashMap<Character,Integer> dfs(ArrayList<ArrayList<Integer>> adj,int v,int p,int[] ans,String labels){
        
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(int i:adj.get(v)){
            if(i == p)
                continue;
            
            HashMap<Character,Integer> temp = dfs(adj,i,v,ans,labels);

            for(Character c:temp.keySet()){
                int count = temp.get(c);
                hm.put(c,hm.getOrDefault(c,0)+count);
            }

        }

        hm.put(labels.charAt(v),hm.getOrDefault(labels.charAt(v),0)+1);
        ans[v]+=(hm.get(labels.charAt(v)));
        return hm;
    }


    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        //Creating a adjancecy matrix

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int[] i:edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        
        int[] ans = new int[n];
        dfs(adj,0,-1,ans,labels);

        return ans;
    }
}