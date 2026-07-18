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
    public boolean isPalindrome(ListNode head) {
        // Base Case
        if(head == null || head.next == null){
            return true;
        }

        // Find mid 
        ListNode mid = findMid(head);
        
        // Reverse 2nd Half
        ListNode prev = null;
        ListNode curr = mid;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // prev is head of 2nd half
        ListNode rightHead = prev;

        // head of leftHead is head of the LinkedList
        ListNode leftHead = head;

        while(rightHead != null){

            if(leftHead.val != rightHead.val){
                return false;
            }

            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }

        return true;
    }

    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    

}