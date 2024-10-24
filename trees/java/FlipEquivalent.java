
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

public class FlipEquivalent {
    public boolean flipEquiv(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        boolean flipCheck1 = flipEquiv(p.left, q.left) && flipEquiv(p.right, q.right);
        boolean flipCheck2 = flipEquiv(p.left, q.right) && flipEquiv(p.right, q.left);

        return flipCheck1 || flipCheck2;
    }
}

