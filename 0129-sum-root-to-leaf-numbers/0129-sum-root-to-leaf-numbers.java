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
    
    int ans = 0;
    
    public void Util(TreeNode root,int sum){
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            //System.out.println(sum*10+root.val);
            ans+=(sum*10+root.val);
            return;
        }
        
        Util(root.left,sum*10+root.val);
        Util(root.right,sum*10+root.val);
          
    }
    
    public int sumNumbers(TreeNode root) {
        ans = 0;
        Util(root,0);
        
        return ans;
    }
}


