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

class MaxPathSum{
  public static int maxi = Integer.MIN_VALUE;
  public static void main(String args[]) {
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(9);
    root.right = new TreeNode(-10);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    int ans  =maxpath(root);
    System.out.println(ans);
  }
  public static int maxpath(TreeNode root){
     getSum(root);
     return maxi;
  }
  public static int getSum(TreeNode root){
    if(root != null){
      int left = Math.max(0, getSum(root.left));
      int right = Math.max(0, getSum(root.right));

      maxi = Math.max(left + right+ root.val, maxi);

      return root.val + Math.max(left, right);

    }
    return 0;
  }
}
