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
    public ListNode reverse(ListNode head, int size){
        ListNode curr = head;
        ListNode prev = null;

        while(size > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            size--;
        }

        return prev;
    }
    public ListNode reverseEvenLengthGroups(ListNode head) {
        // we start expectedSize from 2 beause head is always in group 1
        int expectSize = 2;
        ListNode prev = head;

        while(prev.next != null){
            ListNode curr = prev.next;
            int actualSize = 0;

            ListNode counter = curr;
            while(counter != null && actualSize < expectSize){
                actualSize++;
                counter = counter.next;
            }

            if(actualSize % 2 == 0){
                ListNode headReversal = reverse(curr, actualSize);

                ListNode tail = prev.next;
                prev.next = headReversal;
                tail.next = counter;

                prev = tail;
            }else{
                for(int i = 0; i < actualSize; i++){
                    prev = prev.next;
                }
            }
            expectSize++;
        }

        return head;
    }
}