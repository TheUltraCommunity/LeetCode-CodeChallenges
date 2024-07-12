package stacks.java;
import java.util.Stack;

public class problem_5 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] string = s.toCharArray();
        for (int i = 0; i < string.length; i++) {
            if (string[i] == '(' || string[i] == '[' || string[i] == '{') {
                stack.add(string[i]);
            } else if (string[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if (string[i] == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if (string[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
