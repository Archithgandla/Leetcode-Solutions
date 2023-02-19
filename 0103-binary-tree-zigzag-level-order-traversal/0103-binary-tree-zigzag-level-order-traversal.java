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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null)
            return ans;

        q.add(root);

        while(q.size()>0){
            int count = q.size();

            ArrayList<Integer> Al = new ArrayList<>();
            while(count>0){
                TreeNode temp = q.remove();
                Al.add(temp.val);

                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                count-=1;
            }

            if(flag)
                Collections.reverse(Al);
            ans.add(Al);
            flag = !flag;
        }

        return ans;
    }
}





