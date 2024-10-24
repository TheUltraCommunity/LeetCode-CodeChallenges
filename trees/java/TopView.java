import java.util.*;
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

class Tuple{
  TreeNode node ;
  int x;
  public Tuple(int x, TreeNode node){
    this.x= x;
    this.node = node;
  }
}

public class TopView {
  public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      root.left = new TreeNode(9);
      List<Integer> ans = function(root);
      for (int i = 0; i < ans.size(); i++) {
        System.out.println(ans.get(i));
      }

  }
  public static List<Integer> function(TreeNode root){
    Map<Integer, Integer> map = new TreeMap<>();
    Queue<Tuple> q = new LinkedList<>();
    q.add(new Tuple(0, root));

    while (!q.isEmpty()) {
      Tuple p = q.poll();
      int x = p.x;
      TreeNode node = p.node;

      if(!map.containsKey(x)){
        map.put(x, node.val);
      }

      if(node.left != null){
        q.offer(new Tuple(x-1 , node.left));
      }
      if(node.right != null){
        q.offer(new Tuple(x+1 , node.right));
      }
    }
    List<Integer> ans = new ArrayList<>();
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
      ans.add(entry.getValue());
    }
    return ans;

  }
}
