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

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int start, int end) {

        // Only one list
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode left = divide(lists, start, mid);
        ListNode right = divide(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        return dummy.next;
    }
}

// divide and conquer i used here logic is being same applied of merge two sorted list and here we have to sort the k list so we apply the recursion 