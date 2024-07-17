/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode Util(TreeNode root,List<TreeNode> Al,HashMap<Integer,Integer> hm){

        if(root == null)
            return root;


        root.left = Util(root.left,Al,hm);
        root.right = Util(root.right,Al,hm);

        if(!hm.containsKey(root.val))
            return root;
        
        if(root.left != null)
            Al.add(root.left);
        if(root.right != null)
            Al.add(root.right);

        return null;
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> Al = new ArrayList<>();
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i:to_delete)
            hm.put(i,1);

        Util(root,Al,hm);


        if(!hm.containsKey(root.val))
            Al.add(root);

        return Al;
    }
}












