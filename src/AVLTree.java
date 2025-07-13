 class AVLTree {

    public class TreeNode{

        private int val;
        private TreeNode left;
        private TreeNode right;
        private int height;

        public TreeNode(int val){
            this.val = val;
            this.height = 0;
        }
        public int getValue(){
            return val;
        }
    }

    private TreeNode root;

    public  AVLTree(){

    }

    public  void insert(int value){
        root = insert(value,root);
    }


    private  TreeNode insert(int value,TreeNode node){

        if(node == null){
            node = new TreeNode(value);
            return node;
        }

        if(value < node.val){
            node.left = insert(value,node.left);
        }
        if(value > node.val){
            node.right = insert(value,node.right);
        }

        node.height = Math.max(height(node.left),height(node.right)) +1;
        return  rotate(node);
    }

    private TreeNode rotate(TreeNode node){
        //left heavy
       if(height(node.left) - height(node.right) > 1){
           // left - left heavy
           if(height(node.left.left) - height(node.left.right) > 0){
               return rightRotate(node);
           }
           //left - right heavy
           if(height(node.left.left) - height(node.left.right) < 0){

               node.left =  leftRotate(node.left);
               return rightRotate(node);
           }
       }
       //right heavy
        if(height(node.left) - height(node.right) < -1){
            // right - right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }
            //right - left heavy
            if(height(node.right.left) - height(node.right.right) > 0){

                node.right =  rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;

    }
    private TreeNode leftRotate(TreeNode c){

        TreeNode p = c.right;
        TreeNode t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.right),height(c.left)) + 1;
        p.height = Math.max(height(p.left),height(p.right)) + 1;


        return p;

    }
    private TreeNode rightRotate(TreeNode p){

        TreeNode c = p.left;
        TreeNode t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left),height(p.right)) + 1;
        c.height = Math.max(height(c.right),height(c.left)) + 1;

        return c;

    }


    private int height(TreeNode node){

        if(node == null)return -1;
        return node.height;

    }

    public  boolean balanced(){
        return balanced(root);
    }

    private   boolean balanced(TreeNode node){

        if(node == null)return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);

    }

}
