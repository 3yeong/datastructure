
public class TestBinary {
    public static void main(String[]args)  {
        Binary tree = new Binary();
        Binary tree2 = new Binary();

        int maxsize = 35;
        int size = 0;
        int[]list = {68 ,65 ,62 ,61 ,56 ,54 ,53 ,50 ,49 ,47 ,44 ,42 ,40 ,39 ,34 ,29 ,25 ,24 ,23 ,21 ,19 ,16 ,14 ,11 ,8 ,7 ,5 ,2 ,1};

        int[] list3 = {54 ,39 ,61 ,47 ,68 ,11 ,44 ,56 ,11 ,61 ,45 ,19 ,11 ,15 ,41 ,50 ,48 ,47 ,33 ,24 ,1 ,2 ,5 ,7 ,34};

        int[] list2 = new int[list.length];
        int[] list4 = new int[list.length];


        System.arraycopy(list,0,list4,0,list.length);

        int a = size;
        for(int i = 0; i<size; i++) {
            a--;
            int mid = list4[a/2];
            int ai = list4[a], aj = list[a/2];
            list4[a] = aj;
            list4[a/2] = ai;
            list2[i] = mid;
            if(a<2) {
                list2[i] = list4[0];
                list2[i+1] = list4[1];
                break;
            }
        }

        System.out.println("----insert----");
        for(int i=0; i<list.length; i++) {
            tree.insert(list[i]);
            System.out.print(list[i]);
            System.out.print(" : ");
            System.out.println(tree.insert(list[i]));
        }
        System.out.println("========================");

        System.out.println("----medeian insert----");
        for(int i=0; i<size; i++) {
            tree2.MedianInsert(list2[i]);
            System.out.print(list2[i]);
            System.out.print(" : ");
            System.out.println(tree2.MedianInsert(list2[i]));
        }
        System.out.println("========================");

        if(tree.count1 > tree.count2) {
            System.out.print("insert의 깊이 : ");
            System.out.println(tree.count1);
            System.out.println("========================");

        }else {
            System.out.print("insert의 깊이 : ");
            System.out.println(tree.count2);
            System.out.println("========================");
        }

        if(tree.count3 > tree2.count4) {
            System.out.print("median-insert의 깊이 : ");
            System.out.println(tree2.count3);
            System.out.println("========================");
        }else {
            System.out.print("median-insert의 깊이 : ");
            System.out.println(tree2.count4);
            System.out.println("========================");
        }




        System.out.println("----data Delete----");
        for(int i = 0; i<list3.length; i++) {
            tree.delete(list3[i]);
        }
        System.out.println("========================");







    }

}

