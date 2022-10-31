public class TestBinaryTree {
    public static void main(String [] args){
        BinaryTree tree = new BinaryTree();

        BinaryTree treeP, treeR,treeS, treeT, treeW, treeU;
        BinaryTree treeQ = new BinaryTree("Q");
        BinaryTree treeX = new BinaryTree("X");
        BinaryTree treeY = new BinaryTree("Y");
        BinaryTree treeZ = new BinaryTree("Z");
        BinaryTree treeV = new BinaryTree("V");

        treeW = new BinaryTree("W",treeY,treeZ);
        treeT = new BinaryTree("T",treeV, treeW);
        treeU = new BinaryTree("U",treeX, null);
        treeS = new BinaryTree("S",treeT,treeU);
        treeR = new BinaryTree("R",treeS,null);
        treeP = new BinaryTree("P",treeQ, treeR);

        tree.levelorder(treeP);
        System.out.println();
        tree.preorder(treeP);
        System.out.println();
        tree.inorder(treeP);
        System.out.println();
        tree.postorder(treeP);

    }
}
