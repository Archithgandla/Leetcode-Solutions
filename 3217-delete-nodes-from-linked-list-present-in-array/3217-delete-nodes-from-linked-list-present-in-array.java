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

    boolean BS(int[] arr,int target){
        int low = 0,high = arr.length-1;
        int mid = low+(high-low)/2;

        while(low<=high){
            if(arr[mid] == target)
                return true;
            else if(arr[mid]>target)
                high = mid-1;
            else
                low = mid+1;

            mid = low+(high-low)/2;
        }
        return false;
    }




    public ListNode modifiedList(int[] nums, ListNode head) {
        
        
        ListNode ref = new ListNode(-1);
        ref.next = head;
        Arrays.sort(nums);
        ListNode prev = ref,curr = head,next = null;

        while(curr != null){

            if(BS(nums,curr.val)){
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }

            prev = curr;
            curr = curr.next;
        }

        return ref.next;
    }
}