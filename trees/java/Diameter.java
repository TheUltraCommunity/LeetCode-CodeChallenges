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

public class Diameter{
  private static int max  = 0;
  public static void main(String args[]) {
    TreeNode root= new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right= new TreeNode(5);

    System.out.println(diameter(root));

  }
  public static int diameter(TreeNode root){
    max = 0;
    helper(root);
    return max;
  }
  public static int helper(TreeNode root){
    if(root != null){
      int left  = helper(root.left);
      int right = helper(root.right);
      max  = Math.max(max,  left  + right);
      return 1 + Math.max(left, right) ;
    }
    return 0;
  }
}

