import java.util.ArrayList;
import java.util.Collections;
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
public class ZigZag{
  public static void main(String args[]) {

  }
  public static List<List<Integer>> zig(TreeNode root){
    List<List<Integer>> ans = new ArrayList<>();

    Queue<TreeNode> q = new LinkedList<>();

    q.add(root);
    boolean flag = true;

    while(!q.isEmpty()){
      int level = q.size();
      List<Integer> tmp = new ArrayList<>(Collections.nCopies(level, 0));

      for(int i =0 ; i < level; i++){
        TreeNode polled  = q.poll();
        int index = 0;
        if (flag == true){
          index = i;
        }else{
          index = level - i - 1;
        }
        tmp.set(index, polled.val);

        if(polled.left != null) q.add(polled.left);
        if(polled.right != null) q.add(polled.right);
      }
      ans.add(tmp);
      flag = !flag;
    }
    return ans;
  }
}
