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
    public boolean isEvenOddTree(TreeNode root) {

        //Approach-1
        //Using Level order traversal

        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        q.add(root);

        while(q.size()>0){

            int count = q.size()-1;

            if(q.peek().left != null)
                q.add(q.peek().left);
            if(q.peek().right != null)
                q.add(q.peek().right);

            int prev = q.poll().val;

            if((level%2 == 0 && prev%2 == 0) || (level%2 != 0 && prev%2 != 0))
                return false;

            while(count>0){
                
                TreeNode temp = q.poll();
                //System.out.println(temp.val);

                if(level%2 == 0){            
                    if(temp.val%2 == 0 || temp.val<=prev)
                        return false;
                    prev = temp.val;
                }
                else{
                    if(temp.val%2 != 0 || temp.val>=prev)
                        return false;
                    prev = temp.val;
                }

                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);   
                count-=1;
            }
            level+=1;
        }

        return true;

    }
}













