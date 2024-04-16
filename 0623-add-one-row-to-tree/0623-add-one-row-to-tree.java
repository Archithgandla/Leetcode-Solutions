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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        //Approach-1
        //Using level order traversal

        if(depth == 1){
            TreeNode temp = new TreeNode(val);
            temp.left = root;

            return temp;
        }


        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int d = 1;

        while(q.size()>0){
            
            if(d == depth-1)
                break;

            int count = q.size();

            while(count>0){
                
                TreeNode temp = q.poll();

                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                
                count-=1;
            }
            d+=1;
        }

        //System.out.println(q.peek().val);

        while(q.size()>0){

            TreeNode temp = q.poll();
            TreeNode leftTree = temp.left;
            TreeNode rightTree = temp.right;

            temp.left = new TreeNode(val);
            temp.right = new TreeNode(val);

            temp.left.left = leftTree;
            temp.right.right = rightTree;
        }

        return root;



        //Approach-2
        //Using recurison


    }
}







