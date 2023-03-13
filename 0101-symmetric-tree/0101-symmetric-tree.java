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
    public boolean isSymmetric(TreeNode root) {
        return Util(root.left,root.right);
    }
    
    public boolean Util(TreeNode left,TreeNode right){
        if(left==null && right == null)
            return true;
        
        else if(left == null || right == null)
            return false;
        
        return left.val == right.val && Util(left.right,right.left) && Util(left.left,right.right);
    }
}