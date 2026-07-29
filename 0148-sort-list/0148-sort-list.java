/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

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
    public ListNode sortList(ListNode head) {

        //edge case 
        if(head == null){
            return null ;
        }

        if(head.next == null){
            return head;

        }

        // in oreder to sort the linked list first we have to divide the list into two parts 

        ListNode middle = findMiddle(head); // m1 middle

        ListNode secondHead = middle.next;
        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);

        return merge(left , right);
    }



// as w e are finding m1 middle 
        private ListNode findMiddle(ListNode head){
            ListNode slow = head;
            ListNode fast = head ;

            while(fast.next!= null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;

            }

            return slow ;
        }

        private ListNode merge(ListNode list1 , ListNode list2){

           // / we have two list and we have to merge 

            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy ;
             
            while(list1 != null && list2 != null){
                if(list1.val <= list2.val){
                    temp.next = list1;
                    //if my list1 val is less then temp will join to whole list 1 and list 1moves to next pointer
                    list1 = list1.next;

                }

                else{
                    temp.next = list2;
                    list2 = list2.next;
                }

                temp = temp.next;
            }
            // if list 1 got null earlier 

            while(list1 != null){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            while(list2 != null){
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }

            return dummy.next;
            


        }
        
    
}

        
        
    
