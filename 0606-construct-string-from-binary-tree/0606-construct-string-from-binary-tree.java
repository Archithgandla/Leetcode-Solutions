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
    
    public String Util(TreeNode root){
    
        if(root == null)
            return "()";
        
        String ans = "(";
        ans+=(String.valueOf(root.val));
        
        if(root.left == null && root.right == null)
            return ans+")";
            
        ans+=Util(root.left);            
        
        if(root.right != null)
            ans+=Util(root.right);
        ans+=")";
        return ans;
            
    }
    
    public String tree2str(TreeNode root) {
        
        //Approach-1
        if(root.left == null && root.right == null)
            return String.valueOf(root.val)+""; 
        
        return String.valueOf(root.val)+Util(root.left)+(root.right != null?Util(root.right):"");
        
    }
}






