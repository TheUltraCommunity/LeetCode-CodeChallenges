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

public class Traversals{
  public static void main(String args[]){
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    Pre(root);
    System.out.println();
    Post(root);
    System.out.println();
    Inorder(root);

  }
  public static void Pre(TreeNode root){
    // preorder  traversal means , root, left , right
    // i travserse from root -
    // -> left recursion
    // -> right recursion, until null is encountered wi
    if(root != null){
      System.out.println(root.val);
      Pre(root.left);
      Pre(root.right);
    }
  }
  public static void Post(TreeNode root){
    // we go from left, right, root
    if(root != null){
      Post(root.left);
      Post(root.right);
      System.out.println(root.val);
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


