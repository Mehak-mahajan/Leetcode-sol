/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        // we use fasta nd slow pointers 

        ListNode slow = head ;
        ListNode fast = head ; 

        while(fast != null && fast.next != null){
            // why we check this condition because we have to access every node so thas why we check fast is not null and fast .next not null becayse fast.next.next if fast.next is null then null.next throwsexception

            slow = slow.next ;
            fast = fast.next.next  ;

            if(fast == slow){
                return true ;
            }
        }

        return false ;
        
    }
}

// brute force approach hashset if set contains temp return true else add temp in set and temp = temp.next