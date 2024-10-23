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
public class Symmetric{
  public static void main(String args[]){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.right.left = new TreeNode(8);
    root.right.right = new TreeNode(3);
    System.out.println(sym(root.left, root.right));
  }
  public static boolean sym(TreeNode p, TreeNode q){
    if(p == null && q == null){
      return true;
    }
    if(p == null || q == null){
      return false;
    }
    if(p.val == q.val){
      return sym(p.left, q.right) &&  sym(p.right, q.left);
    }
    return false;
  }
}
