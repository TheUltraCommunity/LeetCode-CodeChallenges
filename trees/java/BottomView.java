import java.util.*;
class Pair{
    int hd ;
    TreeNode node;
    public Pair(int hd, TreeNode node){
        this.hd = hd;
        this.node = node;
    }
}

public class BottomView {
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
    public static List<Integer> function(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        if(root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, root));

        while(!q.isEmpty()){

            Pair polled = q.poll();
            int hd = polled.hd;
            TreeNode node = polled.node;

            map.put(hd, node.val);

            if(node.left != null){
                q.add(new Pair(hd - 1, node.left));
            }

            if(node.right != null){
                q.add(new Pair(hd + 1, node.right));
            }
        }

        for(Map.Entry<Integer, Integer> mp : map.entrySet()){
            ans.add(mp.getValue());
        }

        return ans;
    }
}
