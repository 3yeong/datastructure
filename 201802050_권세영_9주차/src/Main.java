public class Main {
    public static int cnt =0;
    public static void move(int n, char x, char y, char z){
        if(n==0){
            return;
        }else {
            move(n-1, x,z,y);
            System.out.println(x + " -> " + z);
            move(n-1 , y,x,z);
        }
    }

    public static void main (String  [] args){
        move(3, 'A', 'B', 'C');
    }
}
