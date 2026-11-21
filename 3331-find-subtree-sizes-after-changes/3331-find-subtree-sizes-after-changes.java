class Solution {
    
    public void Util(int root,HashMap<Character,Integer> hm,int[] newParent, List<List<Integer>> adj,String s){
        
        if(hm.containsKey(s.charAt(root)))
            newParent[root] = hm.get(s.charAt(root));

        int prev = -1;

        if(hm.containsKey(s.charAt(root)))
            prev = hm.get(s.charAt(root));

        hm.put(s.charAt(root),root);    

        for(int idx:adj.get(root)){
            Util(idx,hm,newParent,adj,s);
        }
        

        if(prev != -1)
            hm.put(s.charAt(root),prev);
        else
            hm.remove(s.charAt(root));

    }
        

    public List<List<Integer>> calculateAdjancentMatrix(int[] parent){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<parent.length;i++){
            adj.add(new ArrayList<>());
        }        

        for(int i=1;i<parent.length;i++){
            adj.get(parent[i]).add(i);
        }

        return adj;
    }

    public int findSize(int root,List<List<Integer>> adj,int[] ans){

        int count = 1;

        for(int idx:adj.get(root)){
            count+=findSize(idx,adj,ans);
        }

        ans[root] = count;

        return count;
    }


    public int[] findSubtreeSizes(int[] parent, String s) {

        List<List<Integer>> adj = calculateAdjancentMatrix(parent);

        int[] newParent = new int[s.length()];

        for(int i=0;i<parent.length;i++)
            newParent[i] = parent[i];

        Util(0,new HashMap<Character,Integer>(),newParent,adj,s);

        adj = calculateAdjancentMatrix(newParent);
        System.out.println(Arrays.toString(newParent));

        int[] ans = new int[s.length()];

        findSize(0,adj,ans);
        
        return ans;

    }
}


