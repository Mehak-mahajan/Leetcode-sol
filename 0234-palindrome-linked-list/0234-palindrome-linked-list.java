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
    public boolean isPalindrome(ListNode head) {

        // optimal approach uses fast and slow pointers whenever we fnd the middle linked list we prefer m2 in chosing middle 

        // here we have to chose m1 

         // edge cases 
         if(head == null){
            return true;
         }

         if(head.next == null){
            return true;
         }
        ListNode fast = head ;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next ;
            fast = fast.next.next;
        }
       // return slow ;
       //right my midddle elemnt is my slow hna i have tro reverse my from slow.next 

       ListNode secondHalf = reverse(slow.next);

    //    because a palindrome means the sequence of values reads the same forward and backward, not that corresponding positions contain the same node object.

    ListNode firsthalf = head ;
    //secondHalf = slow.next ;

    while(secondHalf != null){
        if(firsthalf.val != secondHalf.val ){
            return false;
        }

        firsthalf = firsthalf.next;
        secondHalf = secondHalf.next;

    }
    return true ;
    }






       private ListNode reverse(ListNode head){

        // 5everse in single linkedlist 
        ListNode prev = null; //yet no node processeed 
        ListNode temp = head ;

        while(temp != null){
             ListNode front = temp.next;
        temp.next = prev;

        prev = temp ;
        // next node process 
        temp = front;
        

        } 
        return prev;

       
       



        
    }
}

// brute force take arraylist stored all the values by traversing over the linked list and use two pointers if they are not eual return false else do left ++ right --b and end return true ;



