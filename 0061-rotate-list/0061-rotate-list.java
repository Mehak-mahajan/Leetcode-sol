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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k ==0){
            return head;
        }

        //rotate the list right by k 

        // but in a single ll we cant do roatation from last 

        // count nodes

        int count = 1;
        ListNode temp = head;

        while(temp.next != null){
            temp = temp.next;
            count++;
        }

        // lets suppose length = 5 , rotations bhi 5 is there any need of doing rotation no it will return original listbso i check this case

        // in order to avoid extra roattions 
        k = k % count;

        if(k == 0){
            return head; // avoid extra rotations
        }

        int pos = count - k + 1;

        // now i have to make a new tail

        ListNode prev = null;
        ListNode newhead = head;


        for(int i = 1 ; i < pos ; i++){
            prev = newhead;
            newhead = newhead.next;

        }

        // 1 2 3 4 5 like 3 < 4 so prev become 3 ne head becomes 4 then 4 < 4 noo 

        prev.next = null;


        temp.next = head; /// it point 4 1 23 then what happens to 5

        //the goal is 4 and 5 should be inacted 

        return newhead;

        
    }
}