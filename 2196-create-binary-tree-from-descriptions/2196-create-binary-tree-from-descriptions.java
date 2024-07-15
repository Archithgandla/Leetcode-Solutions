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
    public TreeNode createBinaryTree(int[][] descriptions) {


        HashMap<Integer,TreeNode> hm = new HashMap<>();

        for(int[] des:descriptions){

            TreeNode parent = hm.getOrDefault(des[0],new TreeNode(des[0]));
            TreeNode child =  hm.getOrDefault(des[1],new TreeNode(des[1]));


            if(des[2] == 1)
                parent.left = child;
            else
                parent.right = child;


            if(!hm.containsKey(des[0]))
                hm.put(des[0],parent);
            if(!hm.containsKey(des[1]))
                hm.put(des[1],child);

        }


        TreeNode root = null;

        for(int[] des:descriptions)
            hm.remove(des[1]);

        for(int k:hm.keySet())
            return hm.get(k);

        return null;

    }
}







