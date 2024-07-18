package trees.java;


import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class inorder{
    public static void main(String[] args) {
        
    }
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        fn(root, list);
        return list;
    }
    public static void fn(Node root, List<Integer> ans) {
        if(root == null) return;
        ans.add(root.val);
        fn(root.left, ans);
        fn(root.right, ans);
        return;
    }
    
}

