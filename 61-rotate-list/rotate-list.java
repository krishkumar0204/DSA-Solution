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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }


        int size = 1;
        ListNode oldHead = head;
        ListNode last = head;

        while(last.next != null){
            size++;
            last = last.next;
        }

        k = k % size;
        if(k == 0){
            return head;
        }

        ListNode newTail = head;
        for(int i = 1; i < size - k; i++){
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        last.next = oldHead;

        return newHead;
        
    }
}