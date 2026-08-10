/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        // brute force approach make the copy of ll 

        // ll empty
        if(head == null){
            return null;

        }
        Node temp = head;
        HashMap<Node, Node> map = new HashMap<>();

        while(temp!= null){
            map.put(temp , new Node(temp.val) );

            temp = temp.next;

        }

        temp = head;

        while(temp !=null){
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);

            temp = temp.next;




        }
        return map.get(head);
        

        
        
    }
}

// optimal approach 
// original copy original copy 
// 1 step insert copies copy = temp.nexxt right it is creatin a new node and my copy i.e 1' -> temp.next  2 because temp is at 1 
// 1'-> 2 now mytemp will link to copy so temp.next = copy ie 1 -> 1'
// now temp = temp.next it repats all process of inserting until loop finsishes 

// 2nd step 
// connect random pointers till now 1 -> 1' -> 2 -> 2'->3 -> 3"
// ike 1 it points to 3 2 ppomnirts to 1 and 3 points 2 random pointers 

// 1 -> 1 '-> 2 -> 2'-> 3 -> 3'
// temp .random if temp = 1 then it is 3 and for copy if at 1 temp.random.next and then u can do temp = temp.nexxt until loops stops

// 3rd step 
// separate original and copy we have save the head.next 
// copy.next= copy.next.next and temp.next = copy.next yes then moe temp = temp.next