/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
           int lenA = length(headA);
        int lenB = length(headB);

        ListNode tempA = headA;
        ListNode tempB = headB;

        // Move the longer list ahead
        if (lenA > lenB) {

            int diff = lenA - lenB;

            while (diff > 0) {
                tempA = tempA.next;
                diff--;
            }

        } else {

            int diff = lenB - lenA;

            while (diff > 0) {
                tempB = tempB.next;
                diff--;
            }
        }

        // Move both pointers together
        while (tempA != null && tempB != null) {

            if (tempA == tempB) {
                return tempA;
            }

            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }

    private int length(ListNode head) {

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
        
    }
}

// brute force is traversing over the first list and store into set then traversing upon 2nd list and check whether this value present in set or not 

//as brute force takeextra  space 

// ionj order toptimize we can think how to link the next pointers 

// intersection concept is koi chij tbhi intersect krti agr vo do same distance pr start hui ho 

// pr kloi node length greater ho skti kiskismasller length v hoskti so wecount the bot ll length and then check which length is greater we point the pointer by n diifernce when node covers n distance now both becom equal 
// if they become equal then start pointer moving together if nodes dsme intersect else move pointer till reacges null 


//next optimal apperoafch is if wedont 

// After aligning the starting positions of both pointers so that they have the same number of nodes remaining, if an intersection exists, both pointers will reach the intersection at the same time.