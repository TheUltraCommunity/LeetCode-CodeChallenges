class ListNode {
  int val;
  ListNode? next;
  ListNode([this.val = 0, this.next]);
}

class Solution {
  bool checkIfNull(ListNode? p) {
    return p?.next == null || p?.next?.next == null;
  }

  ListNode? middleNode(ListNode? head) {
    ListNode? a = head;
    ListNode? b = head;
    while (!checkIfNull(a)) {
      b = b?.next;
      a = a?.next?.next;
    }
    if (a?.next != null && a?.next?.next == null) {
      b = b?.next;
    }
    return b;
  }
}
