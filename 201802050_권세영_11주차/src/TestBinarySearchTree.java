public class TestBinarySearchTree {
    public static void main(String[] args){
        BInarySearchTree tree = new BInarySearchTree();

        System.out.println("----------insert---------");
        System.out.println(tree.insert(55));
        System.out.println(tree.insert(22));
        System.out.println(tree.insert(44));
        System.out.println(tree.insert(77));
        System.out.println(tree.insert(70));
        System.out.println(tree.insert(18));
        System.out.println(tree.insert(30));
        System.out.println(tree.insert(27));
        System.out.println(tree.insert(33));
        System.out.println(tree.insert(60));
        System.out.println(tree.insert(74));
        System.out.println(tree.insert(88));
        System.out.println(tree.insert(94));
        System.out.println(tree.insert(80));

        System.out.println("-------contains 30--------");
        System.out.println(tree.contains(30));

        System.out.println("---------delete 30 and 10 ---------");
        tree.delete(30);
        tree.delete(10);

        System.out.println("------contains 30 --------");
        System.out.println(tree.contains(30));


    }
}
