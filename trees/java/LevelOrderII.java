import java.util.ArrayList;
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

public class LevelOrderII{
 public static void main(String[] args) {

  }
 public static List<List<Integer>> levelOrder(TreeNode root){
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();

    q.add(root);
    while(!q.isEmpty()){
        int lvl = q.size();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < lvl; i++) {
          if(q.peek().left !=  null) q.add(q.peek().left);
          if(q.peek().right !=  null) q.add(q.peek().right);

          TreeNode node = q.poll();
          tmp.add(node.val);
        }
        ans.add(tmp);
    }
    return ans;
 }
}
