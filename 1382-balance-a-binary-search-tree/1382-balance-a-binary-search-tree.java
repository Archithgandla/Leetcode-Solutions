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
    
    public void Util(TreeNode root,ArrayList<TreeNode> Al){

        if(root == null)
            return;
        
        Util(root.left,Al);
        Al.add(root);
        Util(root.right,Al);
    }
    
    public TreeNode buildTree(ArrayList<TreeNode> Al,int start,int end){

        if(start == end){
            Al.get(start).left = null;
            Al.get(end).right = null;
            return Al.get(start);
        }        
        if(start>end)
            return null;

        int mid = start+(end-start)/2;

        Al.get(mid).left = buildTree(Al,start,mid-1);
        Al.get(mid).right = buildTree(Al,mid+1,end);
        
        return Al.get(mid);
    }




    public TreeNode balanceBST(TreeNode root) {
        
        ArrayList<TreeNode> Al = new ArrayList<>();
        Util(root,Al);

        return buildTree(Al,0,Al.size()-1);
    }
}



