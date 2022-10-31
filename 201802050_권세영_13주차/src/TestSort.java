public class TestSort {
    public static void main(String[] args){
        Sort s = new Sort();
        int [] x = {66,33,99,55,88,22,44,77};
        System.out.print("처음 배열 : ");
        s.print(x);

        System.out.println();
        s.heap_sort(x);

        System.out.println("heap sort");
        s.print(x);
        System.out.println("\n\n--------------------------------------");

        int [] y = {66,33,99,55,88,22,44,77};
        System.out.print("처음 배열 : ");
        s.print(y);

        System.out.println();
        s.merge_sort(y,0,8);

        System.out.println("merge sort");
        s.print(y);
        System.out.println("\n\n--------------------------------------");

        int [] z = {66,33,99,55,88,22,44,77};
        System.out.print("처음 배열 : ");
        s.print(z);

        System.out.println();
        s.quick_sort(z,0,8);

        System.out.println("quick sort");
        s.print(z);
    }
}
