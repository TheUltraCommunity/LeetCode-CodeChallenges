package java;
import java.util.*;

public class problem_3 {
    public String reverseWords(String s) {
        s = s.trim();
        
        String[] words = s.split("\\s+");
        
        Stack<String> stack = new Stack<>();
        
        for (String word : words) {
            stack.push(word);
        }

        StringBuilder reversed = new StringBuilder();
        
        
        while(!stack.isEmpty()) {
            reversed.append(stack.pop());
            if (!stack.isEmpty()) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }
}