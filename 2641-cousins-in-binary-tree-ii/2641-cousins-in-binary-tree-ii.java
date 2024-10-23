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
    
    
    public void Util(TreeNode root,HashMap<Integer,Integer> hm,int level){
        
        if(root == null)
            return;       
        
        int levelSum = hm.getOrDefault(level+1,0);
        if(root.left != null)
            levelSum-=root.left.val;
        
        if(root.right != null)
            levelSum-=root.right.val;
        
        
        if(root.left != null)
            root.left.val = levelSum;
        
        if(root.right != null)
            root.right.val = levelSum;
        
        Util(root.left,hm,level+1);
        Util(root.right,hm,level+1);
    }
    
    public TreeNode replaceValueInTree(TreeNode root) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        
        while(q.size()>0){
            
            int count = q.size(),levelSum = 0;
            
            while(count>0){
                TreeNode temp = q.poll();
                levelSum+=temp.val;
                
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                
                count-=1;
            }
            hm.put(level,levelSum);
            level+=1;
        }
    
        //System.out.println(hm);
        
        Util(root,hm,1);
        root.val = 0;
        return root;    
            
    }
}











