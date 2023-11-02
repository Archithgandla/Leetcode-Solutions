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

class Pair{
    int sum,count;

    Pair(int sum,int count){
        this.sum = sum;
        this.count = count;
    }

}



class Solution {
    //Alternatively this function can also be written with Pair as return variable and ans as global variable

    public int Util(TreeNode root,Pair p){

        int ans = 0;
        Pair left = new Pair(0,0);
        Pair right = new Pair(0,0);

        if(root.left != null)
            ans+=Util(root.left,left);

        if(root.right != null)
            ans+=Util(root.right,right);

        int avg = (left.sum+right.sum+root.val)/(left.count+right.count+1);

        ans+=(avg == root.val?1:0);        
        p.sum = left.sum+right.sum+root.val;
        p.count = left.count+right.count+1;

        return ans;
    }



    public int averageOfSubtree(TreeNode root) {

        return Util(root,new Pair(0,0));

    }
}

