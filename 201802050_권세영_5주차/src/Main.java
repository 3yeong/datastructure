public class Main {
    public static void main(String [] args){
        BigInt x = new BigInt(2500);
        BigInt y = new BigInt(289);

        System.out.println("두 BigInt를 비교");
        System.out.println(y.equals(x));
        System.out.println("BigInt에 8을 곱한다.");
        System.out.println(y.times(8));
        System.out.println("bigint 두개를 더한다.");
        System.out.println(x.plus(y));
        System.out.println("한 bigint에서 하나를 뺀다");
        System.out.println(x.minus(y));
        System.out.println("bigint의 자리수를 출력한다.");
        System.out.println(x.numdigits());
        System.out.println("bigint를 출력한다.");
        System.out.println(x.toString());



    }
}
