class Node{
    String value;
    Node? node;
    Node(this.value, [this.node]);
}

class Solution {
  bool isValid(String s) {
    Node? stack = null;
    bool answer = true;
    for(int i = 0; i < s.length; i++){
        if((s[i] == ")" && stack?.value != "(") || (s[i] == "]" && stack?.value != "[") || (s[i] == "}" && stack?.value != "{")){
            answer = false;
            break;
        } else if(s[i] == ")" || s[i] == "]" || s[i] == "}"){
            stack = stack?.node;
        }
        else{
            stack = Node(s[i], stack);
            print(stack.value);
        }
    }
    return answer && stack == null;
  }
}
