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
    public List<Integer> largestValues(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<Integer> Al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size()>0){
            
            int count = q.size();
            int maxm = Integer.MIN_VALUE;

            while(count>0){
                
                TreeNode temp = q.poll();
                maxm = Math.max(maxm,temp.val);

                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);

                count-=1;
            }

            Al.add(maxm);
        }

        return Al;

    }
}





