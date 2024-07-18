package trees.java;

import java.util.ArrayList;
import java.util.List;

class Leaf {
    int val;
    Leaf left;
    Leaf right;
    Leaf() {}
    Leaf(int val) { this.val = val; }
    Leaf(int val, Leaf left, Leaf right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class preorder{
    public static void main(String[] args) {
        
    }
    public List<Integer> preorderTraversal(Leaf root) {
        List<Integer> list = new ArrayList<Integer>();
        fn(root, list);
        return list;
    }
    public static void fn(Leaf root, List<Integer> ans) {
        if(root == null) return;
        ans.add(root.val);
        fn(root.left, ans);
        fn(root.right, ans);
        return;
    }
    
}
