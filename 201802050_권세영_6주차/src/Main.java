import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------");
        System.out.println("RPN Calculator");
        System.out.println("Input:");

        String line = new Scanner(System.in).nextLine();
        Scanner s = new Scanner(line);
        String in = s.nextLine();
        Stack st = new ArrayStack(in.length());
        RPN RP = new RPN();

        System.out.println(".....Change to postfix notation");
        String po = RP.postfix(in);

        System.out.println();

        System.out.println("Calculate Value : ");
        System.out.println(RP.result(po));

        System.out.println();

        System.out.println("END RPN Calculator");
        System.out.println("----------");

    }
}

