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
    public int findBottomLeftValue(TreeNode root) {

        //Approach-1
        //Level order traversal

        Queue<TreeNode> q = new LinkedList<>();
        int ans = -1;
        q.add(root);
    
        while(q.size()>0){

            int rowCount = q.size();
            boolean flag = false;

            while(rowCount>0){

                TreeNode temp = q.poll();

                if(!flag){
                    ans = temp.val;
                    flag = true;
                }

                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);

                rowCount-=1;
            }
        }

        return ans;

    }
}







