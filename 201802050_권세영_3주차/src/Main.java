public class Main {
    public static void main(String [] args){
        Set set = new ArraySet();
        set.add("LA");
        set.add("US");
        set.add("MX");
        set.add("RU");
        set.add("US");
        set.add("MX");

        String item = (String) set.getFirst();
        System.out.println(item);

        while((item = (String)set.getNext())!=null)
            System.out.println(item);

        if(set.remove("US")){
            System.out.println("Remove Success");
        }

        item = (String)set.getFirst();
        System.out.println(item);

        while((item=(String)set.getNext())!=null){
            System.out.println(item);
        }
    }
}
