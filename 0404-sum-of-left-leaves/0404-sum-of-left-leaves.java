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
    public int sumOfLeftLeaves(TreeNode root) {

        //Approach-1
        //level order traversal


        // Queue<TreeNode> q = new LinkedList<>();
        // int sum = 0;
        
        // q.add(root);

        // while(q.size()>0){

        //     TreeNode temp = q.poll();

        //     if(temp.left != null){
        
        //         if(temp.left.left == null && temp.left.right == null)
        //             sum+=temp.left.val;
        //         else
        //             q.add(temp.left);
        //     }

        //     if(temp.right != null)
        //         q.add(temp.right);
        // }

        // return sum;

        //Approach-2
        //Recursion

        if(root == null)
            return 0;

        int ans = 0;

        if(root.left != null){
            
            if(root.left.left == null && root.left.right == null)
                ans+=root.left.val;
            else
                ans+=sumOfLeftLeaves(root.left);
        }


        ans+=sumOfLeftLeaves(root.right);

        return ans;


    }
}









