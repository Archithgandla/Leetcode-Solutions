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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> obj = new ArrayList<Integer>();
        
        if(root == null)
            return obj;
        
        if(root.left != null)
            obj.addAll(inorderTraversal(root.left));
        
        obj.add(root.val);
        
        if(root.right != null)
            obj.addAll(inorderTraversal(root.right));
        
        
        return obj;
        
        
    }
} 