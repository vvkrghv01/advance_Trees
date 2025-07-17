
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
       AVLTree tree = new AVLTree();

       for(int i = 0; i < 100000; i++){
           tree.insert(i);
       }

       System.out.println(tree.balanced());
       // if it is not self-balancing binary tree then it will print 1000 or else log(1000)


        int n = 3;
        int m = 2;
        String[] nodes = new String[]{"World","India","China"};
        String[] queries = new String[]{"3 India 9","1 World 9"};

        Map<String, MAryTree.TreeNode> map = new HashMap<>();
        MAryTree.TreeNode root = new MAryTree.TreeNode(nodes[0],null);

        map.put(nodes[0],root);
        Queue<MAryTree.TreeNode> q = new LinkedList<>();
        q.add(root);
        int ind = 1;

        while(q.size() > 0 && ind < n){
            int size = q.size();
            while(size-->0){
                MAryTree.TreeNode removeNode = q.remove();
                for(int i = 1; i <= m && i < ind; i++){
                    MAryTree.TreeNode newNode = new MAryTree.TreeNode(nodes[ind],removeNode);
                    map.put(nodes[ind],newNode);
                    removeNode.child.add(newNode);
                    q.add(newNode);
                    ind++;
                }
            }
        }

        boolean answer = false;

        for(String query : queries){
            String[] parts = query.split(" ");

            if(parts[0].equals("1"))
                answer = lock(map.get(parts[1]), Integer.parseInt(parts[2]));
            else if(parts[0].equals("2"))
                answer = unlock(map.get(parts[1]), Integer.parseInt(parts[2]));
            else
                answer = upgrade(map.get(parts[1]), Integer.parseInt(parts[2]));

        }
        System.out.print(answer);


    }
}