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
    
    int prev;
    int inorder(TreeNode root,int min){
        
        if(root.left != null)
            min = Math.min(min,inorder(root.left,min));
        
        min = Math.min(min,Math.abs(prev-root.val));
        prev = root.val; 

        if(root.right != null)
            min = Math.min(min,inorder(root.right,min));
        return min;
    }
    
    public int getMinimumDifference(TreeNode root) {
                prev = Integer.MAX_VALUE;
        return inorder(root,Integer.MAX_VALUE);
    }
}