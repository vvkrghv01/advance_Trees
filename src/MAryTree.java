import java.util.ArrayList;
import java.util.List;


class MAryTree {

    // structure of TreeNode

    static class TreeNode{
        String name;
        boolean isLocked;
        int id;
        TreeNode parent;
        int anc_locked;
        int des_locked;

        ArrayList<TreeNode> child = new ArrayList<>();
        TreeNode(String name, TreeNode parent){
            this.name = name;
            this.parent = parent;
        }
    }

}
