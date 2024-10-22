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

class Identical{
  public static void main(String args[]) {
    TreeNode p1 = new TreeNode(1);
    p1.left = new TreeNode(2);
    p1.right = new TreeNode(3);

    TreeNode p2 = new TreeNode(1);
    p2.left = new TreeNode(2);
    p2.right = new TreeNode(3);


    System.out.println(check(p1, p2));
  }
  public static boolean check(TreeNode p1, TreeNode p2){

    if(p1 == null && p2 ==  null) return true;
    if(p1 == null || p2 == null) return false;
    if(p1.val == p2.val){
      return check(p1.left, p2.left) && check(p1.right, p2.right);
    }
    return false;
  }
}
