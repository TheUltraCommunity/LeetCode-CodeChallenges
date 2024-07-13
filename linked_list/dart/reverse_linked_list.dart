/**
 * Definition for singly-linked list.
 * class ListNode {
 *   int val;
 *   ListNode? next;
 *   ListNode([this.val = 0, this.next]);
 * }
 */
class Solution {
  ListNode? reverseList(ListNode? head) {
    ListNode? next = head;
    ListNode? answer = null;
    while(next != null){
        answer = ListNode(next?.val ?? 0, answer);
        next = next?.next;
    }
    return answer;
  }
}
