public class BInarySearchTree {
    Node root;
    public Boolean isEmpty(){
        if(this.root == null){
            return true;
        }return false;
    }
    public boolean contains(int value){
        Node p = root;
        if(p.getKey() == value){
            return true;
        }
        while(p!=null){
            if(p.getKey() < value){
                p = p.right;
            }
            else if(p.getKey() > value){
                p = p.left;
            }
            else if(p.getKey() == value){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    public boolean insert(int value){
        Node p = root;
        if(p == null){
            root = new Node(value,null,null);
            return true;
        }
        while( p != null){
          if(p.getKey() > value) {
              if(p.left == null){
                  p.left = new Node(value, null, null);
                  p.setLeft(p.left);
                  return true;
              }
              p = p.left;
          }else{
              if(p.right==null){
                  p.right = new Node(value, null, null);
                  p.setRight(p.right);
                  return true;
              }
              p = p.right;
          }
        }
        return false;
    }
    void delete(int value){
        if(contains(value) == false){
            System.out.println(false);
            return;
        }
        delete(root, value);

    }

    private int values(Node p){
        if(p.getLeft() != null){
            return values(p.getLeft());
        }
        return p.getKey();
    }
    private Node delete(Node r, int data){
        if(r == null){
            return r;
        }
        if(data < r.getKey()){
            r.setLeft(delete(r.getLeft(),data));
        }else if(data>r.getKey()){
            r.setRight(delete(r.getRight(), data));
        }else{
            if(r.getLeft() == null && r.getRight() == null){
                System.out.println(true);
                return null;
            }else if(r.getLeft()==null){
                System.out.println(true);
                return r.getRight();
            }else if(r.getRight() == null){
                System.out.println(true);
                return r.getLeft();
            }else{
                int values = values(r.getRight());
                r.setKey(values);
                r.setRight(delete(r.getRight(),values));
            }
        }
        return r;
    }
    public class Node{
        int key;
        Node left;
        Node right;
        public Node(int key, Node left, Node right){
            this.key = key;
            this.left = left;
            this.right = right;
        }
        public int getKey(){
            return key;
        }
        public  void setKey(int key){
            this.key = key;
        }
        public Node getLeft(){
            return left;
        }
        public void setLeft(Node left){
            this.left = left;
        }
        public Node getRight(){
            return right;
        }
        public void setRight(Node right){
            this.right = right;
        }
    }

}
