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
    public ListNode reverseKGroup(ListNode head, int k) {

        //if ll is emty 
        if(head == null){
            return null;
        }

        // check if k nodes gretear lll is small then reverse is not posible 

        // count the nodes 

        ListNode temp = head;
        int count = 0;

        while(temp != null){
            temp = temp.next;
            count++;
        }

        // if my count total nodes less than k nodes 

        if(count < k){
            return head;
        }

        // reerse first k nodes 

        // as it is a single ll 

        temp = head;
        ListNode prev = null ; 
        count = 0;// last node which processed 

        while(temp != null && count < k){

            ListNode next = temp.next ;

            temp.next = prev;
            prev = temp;
            temp = next;

            count++;
        }

        // still head original node ko point krrha after reversing 321 and head is on 1

        head.next = reverseKGroup(temp , k); // recursively fill 

        return prev;

        
        
    }
}