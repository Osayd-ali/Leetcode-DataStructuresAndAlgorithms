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
//Input: We are given heads of two sorted linked lists, we need to merge these sorted linked list into one sorted linked list, and return the head of our new one sorted linked list. 
// So basically while traversing both of the lists, we check if the curr value of first list is less than the curr value of second list, if it is, then we add that into our global list
// if not, then we add the curr value of second list into our global list. 
// As soon as we are done traversing both of the lists, we add the remaining elements of the list which wasnt fully traversed all at once into our global list. (essentially pointing the curr node's next part to the list1 or list2 node)
// then return the dummy node's next part which will be pointing to the our head of new sorted list. 
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // so list1 is the head of first list
        // list 2 is the head of second list
        // we start traversing both lists simultaneously and keep adding the lesser value to our supposed global list
        // To initialize our hypothetical global list we create a dummy node which points to null
        // then we create a curr node, which signifies our current node of this hypothetical list
        ListNode dummy = new ListNode(0);
        ListNode node = dummy; // Our current node will initially point to the dummy node which is our first node of our linkedlist node

        // Now we start traversing both of our lists simultaneously
        while(list1 != null && list2 != null){
            // now start adding values represented by these head into our global list
            if(list1.val < list2.val){
                // our curr node's next part should point to list1
                node.next = list1;
                // then move forward our list1
                list1 = list1.next;
            } else {
                node.next = list2;
                // then move forward our list2 node
                list2 = list2.next;
            }
            // move our curr node forward. 
            node = node.next;
        }

        // Once we complete traversing either of the lists, add the remaining elements into our resultant list
        if(list1 != null){
            node.next = list1;
        } else {
            node.next = list2;
        }

        return dummy.next;
    }
}