class Node {
  int value;
  Node? node;
  Node(this.value, [this.node]);
}

class MyStack {
  Node? node = null;

  MyStack() {}

  void push(int x) {
    node = Node(x, node);
  }

  int pop() {
    final value = node?.value;
    node = node?.node;
    return value ?? 0;
  }

  int top() {
    return node?.value ?? 0;
  }

  bool empty() {
    return node == null;
  }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = MyStack();
 * obj.push(x);
 * int param2 = obj.pop();
 * int param3 = obj.top();
 * bool param4 = obj.empty();
 */
