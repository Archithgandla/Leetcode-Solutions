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

    public boolean Util(TreeNode root,int target){

        if(root.left == null && root.right == null){
            return root.val == target;
        }

        if(root.left != null && Util(root.left,target))
            root.left = null;

        if(root.right != null && Util(root.right,target))
            root.right = null;

        return root.left == null && root.right == null && root.val == target;

    }


    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        Util(root,target);

        if(root.left == null && root.right == null && root.val == target)
            return null;
        
        return root;
        
    }
}