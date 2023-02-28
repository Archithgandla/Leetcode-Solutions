class Solution {

    HashMap<ArrayList<Integer>,Integer> hm;
    public void Util(TreeNode root,ArrayList<Integer> Al,List<TreeNode> ans){
        if(root == null)
            return;
        Al.add(root.val);
        Al.add(10000);

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        Util(root.left,left,ans);
        Util(root.right,right,ans);

        Al.addAll(left);
        Al.add(10000);
        Al.addAll(right);
        //Al.add(10000);

        if(hm.containsKey(Al) && hm.get(Al) == 1){
            //System.out.println(Al);
            ans.add(root);
            hm.put(Al,2);
        }
        else if(!hm.containsKey(Al))
            hm.put(Al,1);
    
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hm = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();     
        Util(root,new ArrayList<Integer>(),ans);
        return ans;
    }
}