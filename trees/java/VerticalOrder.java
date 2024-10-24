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
  int y;
  public Tuple(int x, int y, TreeNode node){
    this.x= x;
    this.y = y;
    this.node = node;
  }
}

public class VerticalOrder {
  public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);
      root.left = new TreeNode(9);
      List<List<Integer>> ans = function(root);
      for(int j = 0 ;j < ans.size(); j++){
        for (int i = 0; i < ans.get(j).size(); i++) {
          System.out.print(ans.get(j).get(i) + " -> ");
        }
        System.out.println();
      }
  }
  public static List<List<Integer>> function(TreeNode root){
    TreeMap<Integer, Map<Integer, PriorityQueue<Integer>>> tmap = new TreeMap<>();

    Queue<Tuple> q = new LinkedList<>();
    q.add(new Tuple(0, 0, root));

    while (!q.isEmpty()) {
       Tuple p = q.poll();
       int x = p.x;
       int y = p.y;
       TreeNode node = p.node;

      if(!tmap.containsKey(x)){
        tmap.put(x, new TreeMap<>());
      }
      if(!tmap.get(x).containsKey(y)){
        tmap.get(x).put(y, new PriorityQueue<>());
      }

      tmap.get(x).get(y).offer(node.val);

      if(node.left != null){
        q.offer(new Tuple(x-1, y+1, node.left));
      }
      if(node.right != null){
        q.offer(new Tuple(x+1 ,y+1, node.right));
      }
    }

    List<List<Integer>> ans = new ArrayList<>();

    for(Map<Integer, PriorityQueue<Integer>> map : tmap.values()){
      List<Integer> vertical = new ArrayList<>();
      for(PriorityQueue<Integer> verticalNodes : map.values()){
        while(!verticalNodes.isEmpty()){
          vertical.add(verticalNodes.poll());
        }
      }
      ans.add(vertical);
    }
    return ans;
  }
}
