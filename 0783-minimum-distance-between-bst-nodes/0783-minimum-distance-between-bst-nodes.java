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

    //Approach - 1
    //For every node calculate the difference with all the other nodes
    //Time complexity : O(n^2)

    // int inorder(TreeNode root,int ref,int min){
        
    //     if(ref != root.val)
    //         min = Math.min(min,Math.abs(ref-root.val));

    //     if(root.left != null)
    //         min = Math.min(min,inorder(root.left,ref,min));

    //     if(root.right != null)
    //         min = Math.min(min,inorder(root.right,ref,min));
    //     return min;
    // }

    // int Util(TreeNode curr,TreeNode root){
    //     int min = Integer.MAX_VALUE;

    //     min = Math.min(min,inorder(root,curr.val,min));

    //     if(curr.left != null)
    //         min = Math.min(min,Util(curr.left,root));
    //     if(curr.right != null)
    //         min = Math.min(min,Util(curr.right,root));
    //     return min;
    // }

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


    public int minDiffInBST(TreeNode root) {
        //App-1
        // return Util(root,root);

        //App-2
        //Peform inoder traversal and calculate the diff between adjacent elements
        //in sorted order and take miniimum difference
        prev = Integer.MAX_VALUE;
        return inorder(root,Integer.MAX_VALUE);

    }   
}




