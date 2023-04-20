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

//Refer code with mik
class Pair{
    TreeNode node;
    int index;

    Pair(TreeNode node,int index){
        this.node = node;
        this.index = index;
    }
}


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root.left ==  null && root.right == null)
            return 1;

        Deque<Pair> dq = new ArrayDeque<>();
        dq.addLast(new Pair(root,0));
        int ans = Integer.MIN_VALUE;

        while(dq.size()>0){
            int count = dq.size();

            while(count>0){
                Pair p = dq.removeFirst();
                int index = p.index;
                TreeNode n = p.node;

                if(n.left != null)
                    dq.add(new Pair(n.left,2*index+1));
                if(n.right != null)
                    dq.add(new Pair(n.right,2*index+2));
                count-=1;
            }
            if(dq.size()>0)
                ans = Math.max(ans,dq.getLast().index-dq.getFirst().index+1);
        }
        return ans;

    }
}

        //Giving TLE
        // int ans = Integer.MIN_VALUE;
        // Queue<TreeNode> q = new LinkedList<>();
        
        // q.add(root);
        
        // while(q.size()>0){
        //     int count = q.size();
            
        //     boolean flag = false;
        //     int local = 0;
        //     flag = false;
            
        //     while(count>0){
                
        //         TreeNode temp = q.poll();
                
        //         if(temp == null){
        //             q.add(null);
        //             q.add(null);

        //             if(flag)
        //                 local+=1;
        //             count-=1;
        //             continue;
        //         }
                
        //         flag = true;
                
                
        //         q.add(temp.left);                
        //         q.add(temp.right);


        //         local+=1;
                
        //         ans = Math.max(ans,local);
        //         //System.out.println(ans);
        //         count-=1;
        //         //System.out.println(count);
        //     }
            
        //     if(!flag)
        //         break;
            
        // }
        
        // return ans;