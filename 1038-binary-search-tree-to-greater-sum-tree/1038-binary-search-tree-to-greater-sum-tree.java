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
    
    int sum = 0;

    
    //Using inorder traversal
    public void Util(TreeNode root){

        if(root == null)
            return;
        
        Util(root.right);

        int temp = root.val;

        root.val+=sum;
        sum+=temp;

        Util(root.left);

    }
    
    public TreeNode bstToGst(TreeNode root) {

        sum = 0;

        Util(root);

        return root;

    }
}








