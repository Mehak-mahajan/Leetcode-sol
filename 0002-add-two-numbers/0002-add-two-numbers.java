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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // add twpo numbers 
        // generally we did addition from last digit 

        // we reverse it as we strt from first

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0; 
        int sum = 0;
// as our sum forms by adding two values carry also involved 

        while( l1 != null || l2 != null || carry !=0){

            sum = carry;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;

            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            // jb hukmne add kiya to kya carry generate hui 
             carry = sum / 10; // yh agle digit pr shift hotoi carry 

             temp.next = new ListNode (sum % 10);
             
               // jo add kiya vo node bnga 

               temp = temp.next;

           

        }
        return dummy.next;
        
    }
}

// why we write that while condition because agr l1 empty kya pta l2 nq ho to l2kli values to add mein add hoti yn dono null aur last tk carry ki vakllue not 0 that carry also create a newnode 