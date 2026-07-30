/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
           int lenA = length(headA);
        int lenB = length(headB);

        ListNode tempA = headA;
        ListNode tempB = headB;

        // Move the longer list ahead
        if (lenA > lenB) {

            int diff = lenA - lenB;

            while (diff > 0) {
                tempA = tempA.next;
                diff--;
            }

        } else {

            int diff = lenB - lenA;

            while (diff > 0) {
                tempB = tempB.next;
                diff--;
            }
        }

        // Move both pointers together
        while (tempA != null && tempB != null) {

            if (tempA == tempB) {
                return tempA;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }

    private int length(ListNode head) {

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
        
    }
}