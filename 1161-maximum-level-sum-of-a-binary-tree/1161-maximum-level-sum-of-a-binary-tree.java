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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxm = Integer.MIN_VALUE,level = 0,ans = -1;


        while(q.size()>0){
            int count = q.size();
            int sum = 0;
            level+=1;

            while(count>0){
                TreeNode temp = q.poll();
                sum+=temp.val;

                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                count-=1;
            }

           if(sum>maxm){
               maxm = sum;
               ans = level;
           }
        }
        return ans;

    }
}








