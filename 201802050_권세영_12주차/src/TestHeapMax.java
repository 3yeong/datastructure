public class TestHeapMax {
    public static void main(String[] args){
        HeapMax max = new HeapMax(20);
        max.add(3,30);
        max.add(4,19);
        max.add(1,36);
        max.add(5,100);
        max.add(6,17);
        max.add(2,3);
        max.add(7,29);
        max.add(9,23);
        max.add(8,2);

        max.print();

        System.out.println();

        System.out.println("가장 큰 값은 : " + max.best());

        System.out.println("가장 큰 값 삭제");
        max.removeBest();

        max.print();

        System.out.println();

        System.out.println("가장 큰 값은 : " + max.best());
    }
}
