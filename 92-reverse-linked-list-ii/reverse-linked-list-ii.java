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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right || head == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode before = dummy;
        ListNode temp = head;

        int pos = 1;
        while(pos < left){
            before = temp;
            temp = temp.next;
            pos++;
        }

        int times = right - left + 1;
        ListNode curr = temp;
        ListNode prev = null;

        while(curr != null && times > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;
        }

        temp.next = curr;
        before.next = prev;
        
        return dummy.next;
    }
}