package stacks.java;
import java.util.*;

public class problem_6 {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int topElement;

    public problem_6() {
        //rename class to myStack
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
        topElement = x;
    }

    public int pop() {
        while (q1.size() > 1) {
            topElement = q1.remove();
            q2.add(topElement);
        }
        int poppedElement = q1.remove();
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return poppedElement;
    }

    public int top() {
        return topElement;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
