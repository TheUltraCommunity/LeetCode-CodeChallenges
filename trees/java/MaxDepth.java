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


public class MaxDepth{
  public static void main(String args[]) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    //root.left.left = new TreeNode(4);

    root.right = new TreeNode(3);
    root.right.right = new TreeNode(5);
    //root.right.right = new TreeNode(7);
    //root.right.right.right = new TreeNode(8);
    System.out.println(maxDepth(root));
  }

  public static int maxDepth(TreeNode root){
    int maxi = 0;
    if(root != null){
      int left = maxDepth(root.left);
      int right = maxDepth(root.right);
      maxi = 1 + Math.max(left, right);

    }
    return maxi;
  }
}
