package trees.java;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class postorder{
    public static void main(String[] args) {
        
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        fn(root, list);
        return list;
    }
    public static void fn(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        fn(root.left, ans);
        fn(root.right, ans);
        ans.add(root.val);
        return;
    }
    
}
