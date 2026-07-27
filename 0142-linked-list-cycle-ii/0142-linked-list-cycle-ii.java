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
    public ListNode detectCycle(ListNode head) {

        // 1st phase detect cycle 

        ListNode slow = head ;
        ListNode fast = head ;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast ){
                // that means a cycle is forming then we make a new pointer at the start of head 

                ListNode newptr = head ;

                // move both one by one 

             while(newptr != slow){
             //   e don't know how many steps it'll take.

//Maybe they'll meet after:

//2 steps
//5 steps
//10 steps

//So we keep moving until they point to the same node.

            newptr = newptr.next;
            slow = slow.next;


            }
            return newptr ;
            }


                }

           
        
        return null;
        
        
    }
}

// Why start from head?

// The answer we want is:

// Where does the cycle begin?

// The only pointer that hasn't entered the cycle yet is a pointer starting from the head.

// So we create:


// Great question. The answer is no. After detecting the cycle, if you keep moving slow by 1 and fast by 2, they will keep meeting inside the cycle, but not necessarily at the start of the cycle.

// Eventually they'll meet again, but that meeting point depends on the cycle length. It is not guaranteed to be the start of the cycle.

// The meeting point is guaranteed to be the start of the cycle because of the relationship created when fast (moving twice as fast) first caught slow.

