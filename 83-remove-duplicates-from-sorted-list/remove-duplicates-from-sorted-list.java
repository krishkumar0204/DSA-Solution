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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode pos = head;
        ListNode officer = head.next;

        while(officer != null){
            if(pos.val == officer.val){
                pos.next = officer.next;
                officer = officer.next;
            }else{
                officer = officer.next;
                pos = pos.next;
            }
        }

        return head;
    }
}