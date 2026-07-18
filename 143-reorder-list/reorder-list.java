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
    public void reorderList(ListNode head) {

        ListNode mid = findMid(head);

        // reverse 2nd Half
        ListNode curr = mid.next;
        mid.next = null;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // prev is the head of 2nd Half
        ListNode rightHead = prev;

        // head of leftHead is head of the linked List
        ListNode leftHead = head;

        // Taking two Linked for use as like pointer
        ListNode nextL, nextR;

        while(leftHead != null && rightHead != null){
            
            nextL = leftHead.next;
            leftHead.next = rightHead;

            nextR = rightHead.next;
            rightHead.next = nextL;

            leftHead = nextL;
            rightHead = nextR;
        }
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