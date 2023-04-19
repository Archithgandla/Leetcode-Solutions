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

//For each node there are two options they are 
//1)Follow the coming from its parent
//2)start new from itself
//The answer obtained by following its parent must be returned since it must
//be used by its parent
//answer obtianed considering itself as the starting point need not to be returned
//because however its parent cannot use it since it is out of range
//Time complexity : O(Number of nodes)
//since we are visiting each node once

class Solution {

    int ans = Integer.MIN_VALUE;

    public int Util(TreeNode root,boolean flag){
        if(root == null)
            return 0;
        
        //continuing with previous flow
        int prev;
        
        if(flag)
            prev = 1+Util(root.left,!flag);
        else
            prev = 1+Util(root.right,!flag);

        //starting from the current node
        //if parent path goes through left u go through right since
        //parent path is already discovering it and it is obviously bigger beacuse of ancestors
        int curr = 1+ (flag?Util(root.right,false):Util(root.left,true));
        ans = Math.max(ans,curr);
        return prev;
    }

    public int longestZigZag(TreeNode root) {
        int left = Util(root,false);
        int right = Util(root,true);

        return Math.max(1+left,Math.max(1+right,ans))-2;
    }

}


