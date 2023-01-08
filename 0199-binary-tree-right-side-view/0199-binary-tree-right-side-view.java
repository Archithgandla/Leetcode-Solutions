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
    
    //Method - 1
    //Use The method mentioned in GFG
    //In each level of tree use right node and if left not present then take left
    //Do this on both right and left tree and 
    //if len(left)>len(right)
    //Then add those extra elements to the right array
    //return right array
    
    //Method - 2
    
    public void Util(TreeMap<Integer,Integer> hm,int level,TreeNode root){
        if(root == null)
            return;
        
        if(!hm.containsKey(level))
            hm.put(level,root.val);
        
        Util(hm,level+1,root.right);
        Util(hm,level+1,root.left);
    }
    
    
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        
        Util(hm,0,root);
        
        for(int i:hm.keySet())
            ans.add(hm.get(i));
        
        return ans;
    }
}