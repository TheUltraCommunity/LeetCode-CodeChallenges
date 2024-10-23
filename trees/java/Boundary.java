import java.util.*;

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

public class Boundary {
  public List<Integer> boundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        if(!isLeaf(root)){
            res.add(root.val);
        }
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;

    }

    public static boolean isLeaf(TreeNode root){
        return (root.left == null && root.right == null);
    }

    public void addLeaves(TreeNode root, List<Integer> res){
        if(isLeaf(root)){
            res.add(root.val);
            return;
        }
        if(root.left != null){
            addLeaves(root.left, res);
        }
        if(root.right != null){
            addLeaves(root.right, res);
        }
    }
    public static void addLeftBoundary(TreeNode node, List<Integer> res){
        TreeNode curr = node.left;
        while(curr != null){
            if(!isLeaf(curr)){
                res.add(curr.val);
            }
            if(curr.left != null){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void addRightBoundary(TreeNode node, List<Integer> res){

        TreeNode curr = node.right;
        List<Integer> temp = new ArrayList<>();

        while(curr != null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        for(int i = temp.size() - 1 ; i >= 0 ; i--){
            res.add(temp.get(i));
        }
    }
}

