import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

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


class Cousins{
  public static void main(String args[]) {
      TreeNode root = new TreeNode(5);
      root.left = new TreeNode(4);
      root.right = new TreeNode(5);
      root.left.left= new TreeNode(1);
      root.left.right = new TreeNode(10);
      root.right.right = new TreeNode(7);

      Inorder(root);
      System.out.println("______________________");

      function(root);
      root.val = 0;
      root.left.val = 0;
      root.right.val = 0;
      Inorder(root);
  }
  public static void function(TreeNode root) {

      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      root.val =0;
      while(!q.isEmpty()){
        int level = q.size();
        int levelSum = 0;

        Queue<TreeNode> tq = new LinkedList<>(q);
        for (int i = 0; i < level; i++) {
            TreeNode polled = tq.poll();
            levelSum += polled.val;
            if (polled.left != null) levelSum += polled.left.val;
            if (polled.right != null) levelSum += polled.right.val;
        }

        for (int i = 0; i < level; i++) {
          TreeNode curr = q.poll();

          int siblings =0 ;
          if(curr.left != null) {
            siblings +=curr.left.val;
            q.add(curr.left);
          }
          if(curr.right != null){
            siblings += curr.right.val;
            q.add(curr.right);
          }

          if(curr.left != null){
            curr.left.val = Math.abs(levelSum - siblings);
          }
          if(curr.right!= null){
            curr.right.val = Math.abs(levelSum - siblings);
          }

          }
      }
  }
    public static void Inorder(TreeNode root){
    /// left to root to right
    if(root !=  null){
        Inorder(root.left);
        System.out.println(root.val);
        Inorder(root.right);
    }
  }

}
