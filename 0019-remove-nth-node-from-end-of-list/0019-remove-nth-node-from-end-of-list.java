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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // optimal and brute forcehas only one difference that optiml includes only 1 pass 

        if(head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head ;

        // main goal to del n noderight to del n nodehum kya krte hume hmesha ek node se phle rhna hota fast ko 2 points ahead set krdu and then slow aur fastr ko ikhthe move kravau 

        //move fast n steps
        for(int i = 1 ; i <= n ; i++ ){
            fast = fast.next;
        }

        // lets take example we have 10 20 30 and n =3 at initial fast is at head ie at 10 now we have to move it 3 steaps ahead but then fast == null and we have to del n=3 from end that means head = head.next
        if(fast == null){
           return head.next;
        }

        while(fast.next != null){
        slow = slow.next ;
        fast = fast.next;
        // now they mov togethrr 

        }

        // now my slow is one node before the node which we hve to del 
        slow.next = slow.next.next;

        return head ;

        

        
    }
}

