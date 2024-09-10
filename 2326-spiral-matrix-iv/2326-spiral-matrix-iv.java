/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        
        
        int[][] ans = new int[m][n];
        
        for(int[] arr:ans)
            Arrays.fill(arr,-1);
        
        int top = 0,bottom = m-1,left = 0,right = n-1;
        //ListNode temp = head;
        
        while(left<=right && top<=bottom && head != null){
            
            
            int temp = left;
            while(temp<=right && head != null){
                ans[top][temp] = head.val;
                temp+=1;
                head = head.next;
            }
            
            top+=1;
            
            temp = top;
            while(temp<=bottom && head != null){
                ans[temp][right] = head.val;
                temp+=1;
                head = head.next;
            }
            right-=1;
            
            temp = right;
            
            while(temp>=left && head != null){
                ans[bottom][temp] = head.val;
                temp-=1;
                head = head.next;
            }
            bottom-=1;
            
            temp = bottom;
            while(temp>=top && head != null){
                ans[temp][left] = head.val;
                temp-=1;
                head = head.next;
            }
            left+=1;       
        }
        
        return ans;
        
    }
}





