import java.util.ArrayList;
import java.util.List;


class MAryTree {

    public class MAryTreeNode{
        int val;
        List<MAryTreeNode> children;

        public MAryTreeNode(int val){
            this.val = val;
            this.children = new ArrayList<>();

        }
        public void addChild(MAryTreeNode child){
            children.add(child);
        }
    }
    MAryTreeNode root = new MAryTreeNode(1);
    MAryTreeNode node2 = new MAryTreeNode(2);
    MAryTreeNode node3 = new MAryTreeNode(3);
    MAryTreeNode node4 = new MAryTreeNode(4);
    MAryTreeNode node5 = new MAryTreeNode(5);
    MAryTreeNode node6 = new MAryTreeNode(6);

//    root.addChild(node2);
//    root.addChild(node3);
//    root.addChild(node4);
//    node3.addChild(node5);
//    node3.addChild(node6);

}
