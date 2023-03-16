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

    int index;
    TreeNode Util(int[] inorder,int[] postorder,int low,int high,
    HashMap<Integer,Integer> hm){
        if(low == high){
            index-=1;
            return new TreeNode(inorder[low]);
        }
        int root_index = hm.get(postorder[index]);
        int rootVal = inorder[root_index];
        index-=1;

        TreeNode root = new TreeNode(rootVal);

        //Taking right first then left beacuse
        //in post order we have L R root
        //so since we are coming from end we will encounter right tree first
        if(root_index+1<=high)
            root.right = Util(inorder,postorder,root_index+1,high,hm);

        if(root_index-1>=low)
            root.left = Util(inorder,postorder,low,root_index-1,hm);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //This technique will not work if the tree contains duplicate values
        HashMap<Integer,Integer> hm = new HashMap<>();
        index = inorder.length-1;

        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i],i);

        return Util(inorder,postorder,0,inorder.length-1,hm);

    }
}




