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

public class Balanced{
  public static void main(String args[]){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(3);

    System.out.println(check(root));
  }
  public static boolean check(TreeNode root){
    if(root == null){
      return true;
    }
    int left = getHeight(root.left);
    int right = getHeight(root.right);

    if(Math.abs(left - right) <= 1 && check(root.left) && check(root.right)){
       return true;
    }
     return false;
 }
  public static int getHeight(TreeNode root){
    if(root != null){


      int left = getHeight(root.left);
      int right = getHeight(root.right);

      return Math.max(left, right) +1 ;
    }
    return 0;
  }

}
