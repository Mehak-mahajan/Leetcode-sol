/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // del node by value ;
class Solution {
    public void deleteNode(ListNode node) {
        
        // if(head == null){
        //     return null ;
        // }

        // if(head.data == x){
        //     return head.next;
        // }

        // ListNode temp = head ;

        // while(temp.next != null && temp.data.next != x){
        //     temp = temp.next;
        // }

        // if(temp.next!= null){
        //     temp.next = temp.next.next;
        // }

        // idea next node value ko current mein copy 

        node.val = node.next.val;
        // 4 - 5 - 1 - 9  ---->>> 4 1 1 9
        node.next = node.next.next;




        
    }
}


//Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list; instead, you will be given access to the node to be deleted directly.

// also problem states that the del node is not theb last node 