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

//Input: We are given a head of a linked list which usually points to the first node. 
// reverse the list and return the new beginning of the linked list
// Since we are only given the head of the linked list
// the approach would be, we will first traverse through the entire linked list
// we do this by initializing a curr reference and a prev reference. this is the keep track of the currently visited node, and its previous node
// initially, the curr node will be pointing to the head (i.e. the first node of the original linked list pointed by head)
// the prev node will be pointing to null(Because, for now, we do now have any previoud node)
// We keep visiting each node, by accessing the address part of the curr node (.next) until curr points to null, this means we have traversed the entire linked list and curr is now pointing to null. 
// All of this happens in a while loop as we dont know the end of the linked list. 

// Now we initialize a temporary node which will contain the address part of the current node
// now the core logice of reversal will be applied
// the curr node's next part will point to the prev node
// now make our prev reference point to curr, signifying that the current element becomes the previous node
// now we need to go to the next node in order to move forward, we already stored the address of next node in temp, so just point the curr node to temp.
// This goes on, untill the curr node points to null, that means we have visited the last node
// Now just return prev, which will be the new head of the reversed linked list. 

class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        // Now start linkedlist traversal 
        while(curr != null){
            // store the next node's address in a temp node, so that we move forward once reversal is done
            ListNode temp = curr.next;
            // Now curr node's address part should be pointing to prev node
            curr.next = prev;
            // Now, once that is done, our current node will become the new prev node
            prev = curr;
            // now we move forward by assigning curr reference to the temp (which points to the next node)
            curr = temp;
        }
        return prev;
    }
}
