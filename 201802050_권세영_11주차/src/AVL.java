class AVLNode{
    AVLNode left, right;
    int key;
    int height;
    public AVLNode(){
        left = null;
        right = null;
        key = 0;
        height = 0;
    }
    public AVLNode(int n){
        left = null;
        right = null;
        key = n;
        height = 0;
    }
}

public class AVL {
    private AVLNode root;
    public  void insert(int data){
        root = insert(data, root);
    }
    private AVLNode insert(int value, AVLNode p){

        if(p == null){
            return (new AVLNode(value));
        }
        if(value<p.key){
            p.left = insert(value, p.left);
        }else if (value > p.key){
            p.right = insert(value, p.right);
        }else{
            return p;
        }

        p.height = 1+max(height(p.left), height(p.right));

        int balance = balance(p);

        if(balance > 1 && value < p.left.key)
            return rotateRight(p);
        if(balance < -1 && value > p.right.key)
            return rotateLeft(p);
        if(balance > 1 && value>p.left.key){
            p.left = rotateLeft(p.left);
            return rotateRight(p);
        }
        if(balance < -1 && value < p.right.key){
            p.right = rotateRight(p.right);
            return rotateLeft(p);
        }
        return p;
    }
    int balance(AVLNode p){
        if( p == null ){
            return 0;
        }
        return height(p.left) - height(p.right);
    }
    private int max(int a, int b)
    {
        return a > b ? a : b;
    }
    int height(AVLNode p){
        if(p == null)
            return 0;
        return p.height;
    }
    private AVLNode rotateLeft(AVLNode p){
        AVLNode x = p.left;
        AVLNode y = x.right;

        x.right = p;
        p.left = y;

        p.height = max(height(p.left),height(p.right))+1;
        x.height = max(height(x.left),height(x.right))+1;

        return x;
    }
    private AVLNode rotateRight(AVLNode p){
        AVLNode y = p.right;
        AVLNode x = y.left;

        y.left = p;
        p.right = x;

        p.height = max(height(p.left),height(p.right))+1;
        y.height = max(height(y.left),height(y.right))+1;

        return y;
    }
    public boolean search(int val) {
        AVLNode p = root;
        if (p.left.key == val) {
            return true;
        }
        while (p != null) {
            if (p.key < val) {
                p = p.right;
            } else if (p.key > val) {
                p = p.left;
            } else if (p.key == val) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public void inorder(){
        inorder(root);
    }
        private void inorder (AVLNode p) {
            if(p == null)
                return;
            inorder(p.left);
            System.out.println(p.key + " ");
            inorder(p.right);
        }
           public void preorder(){
                preorder(root);
    }
            private void preorder (AVLNode p) {
               if (p != null) {
                System.out.println(p.key + " ");
                preorder(p.left);
                preorder(p.right);
               }
        }

        public void postorder(){
            postorder(root);
    }
        private void postorder(AVLNode p) {
            if(p == null)
                return;
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.key + " ");
        }

}
