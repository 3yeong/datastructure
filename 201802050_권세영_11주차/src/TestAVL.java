public class TestAVL {
    public static void main(String  [] args){
        AVL a = new AVL();

        System.out.println("-----------insert----------");
        a.insert(30);
        a.insert(10);
        a.insert(20);
        a.insert(40);
        a.insert(50);
        a.insert(35);
        System.out.println();
        System.out.println("----------preorder---------");
        a.preorder();


    }
}
