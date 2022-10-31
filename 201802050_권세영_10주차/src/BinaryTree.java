import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTree  {
    private Object root;
    private BinaryTree left, right;

    public String toString(){
        return root + " ";
    }

    public  BinaryTree(){

    }

    public BinaryTree(Object root){
        this.root = root;
    }
    public  BinaryTree(Object root, BinaryTree left, BinaryTree right){
        this.root = root;
        if(left!=null) this.left = left;
        if(right!=null)this.right = right;
    }
    public Object getRoot(){
        return this.root;
    }
    public BinaryTree getLeft(){
        return this.left;
    }
    public BinaryTree getRight(){
        return this.right;
    }
    public Object setRoot(Object ob){
        Object oldob = this.root;
        this.root = ob;
        return oldob;
    }
    public BinaryTree setleft(BinaryTree tree){
        BinaryTree oldtree = this.left;
        this.left = tree;
        return oldtree;
    }
    public BinaryTree setright(BinaryTree tree){
        BinaryTree oldtree = this.right;
        this.right = tree;
        return oldtree;
    }

    void levelorder(BinaryTree tree){
        System.out.print("levelorder : ");
        Queue<BinaryTree> q = new LinkedList<>();
        q.add(tree);
        while(!q.isEmpty()){
            System.out.print(q.peek());
            q.remove();
            if(tree.left != null){
                q.add(tree.getLeft());
            }
            if(tree.right != null){
                q.add(tree.getRight());
            }
            tree = q.peek();
        }
    }

    void preorder(BinaryTree tree){
        System.out.print("preorder : ");
        Stack<BinaryTree> s = new Stack<>();
        s.push(tree);
        while (!s.isEmpty()){
            System.out.print(s.pop());
            if(tree.right!=null){
                s.push(tree.getRight());
            }
            if(tree.left != null){
                s.push(tree.getLeft());
            }
            if(!s.isEmpty())
                tree = s.peek();
        }
    }
    void postorder(BinaryTree tree) {
        System.out.print("postorder : ");
        Stack<BinaryTree> st = new Stack<>();
        st.push(tree);
        while(!st.isEmpty()){
            tree = st.peek();
            if(tree.left == null && tree.right==null){
                System.out.print(st.peek());
                tree = st.pop();
            }else{
                if(tree.right!=null){
                    st.push(tree.getRight());
                    tree.right = null;
                }
                if(tree.left != null){
                    st.push(tree.getLeft());
                    tree.left = null;
                }
            }
        }
    }
    void inorder(BinaryTree tree){
        System.out.print("inorder : ");
        Stack<BinaryTree> st = new Stack<>();
        while(!st.empty()||tree!=null){
            if(tree!=null){
                st.push(tree);
                tree = tree.getLeft();
            }else{
                tree = st.pop();
                System.out.print(tree);
                tree = tree.getRight();

            }
        }
    }
}
