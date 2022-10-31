public class BigInt {
    private Node start;
    public  int size = 0;
    private static class Node {
        int digit;
        Node next;

        Node(int digit) {
            this.digit = digit;
        }
    }
        public BigInt(int n){
            if(n<0) throw new IllegalArgumentException(n + "<0");
            start = new Node(n%10);
            size ++;
            Node p =start;
            n/= 10;
            while (n>0) {
                p = p.next = new Node(n % 10);
                n /= 10;
            }
        }
        public BigInt(String n){
            if(n.length() == 0)
                throw new IllegalArgumentException("empty string");
            start = new Node (digit(n, n.length()-1));
            size ++;
            Node p = start;
            for(int i = n.length()-2; i>=0; i--)
                p = p.next = new Node(digit(n,i));
        }
        private int digit(String s, int i) {
            String ss = s.substring(i, i + 1);
            return Integer.parseInt(ss);
        }
        public  BigInt plus (BigInt y){
            Node p = start, q = y.start;
            int n = p.digit+ q.digit;
            BigInt z = new BigInt(n%10);
            Node r=z.start;
            p = p.next;
            q = q.next;
            while (p != null && q != null) {
                n = n/10 + p.digit+ q.digit;
                r.next = new Node(n%10);
                p = p.next;
                q = q.next;
                r = r.next;
            }
            while (p != null) {
                n = n/10 + p.digit;
                r.next = new Node(n%10);
                p = p.next;
                r = r.next;
            }
            while (q != null) {
                n = n/10 + q.digit;
                r.next = new Node(n%10);
                q = q.next;
                r = r.next;
            }
            if (n > 9) r.next = new Node(n/10);
            return z;
        }
        public BigInt minus(BigInt y){
            Node p = start , q = y.start;
            int n = 0;
            int flag =0;
            Node r = null;
            BigInt z = null;
            while(q != null){
                if(p.digit-flag >= q.digit){
                    n = p.digit - q.digit - flag;
                    flag = 0;
                    if(r == null){
                         z = new BigInt(n);
                        r = z.start;
                    }else {
                        r.next = new Node(n);
                        r = r.next;
                    }
                    p = p.next;
                    q = q.next;
                }
                else {
                    n = 10 - q.digit - flag + p.digit;
                    flag = 1;
                    if(r == null) {
                         z = new BigInt(n);
                        r = z.start;
                    }else {
                       r.next = new Node(n);
                       r = r.next;
                    }
                    p = p.next;
                    q = q.next;
                }
            }
            while (p!=null){
                n = p.digit - flag;
                r.next = new Node(n);
                r = r.next;

                flag = 0;
                p = p.next;
            }
            return z;
        }
        Boolean equals (BigInt y){
            if(!(y instanceof  BigInt))
                throw new IllegalArgumentException();
            BigInt x = (BigInt) y;
            if(this == x)
                return true;
            else
                return false;

        }
        int intValue(){
            int Value;
            try {
                Value = Integer.parseInt(this.toString());
            }
            catch (Exception e) {
                Value = 0;
            }
            return Value;
        }
        int numdigits(){
            int k = 0;
            Node p = start;
            while(p != null){
                k ++;
                p = p.next;
            }
            return k;
        }
        BigInt times(int n){
            Node p = start;
            int temp = p.digit * n;
            BigInt z = new BigInt(temp%10);
            Node q = z.start;
            p = p.next;
            while (p!=null) {
                temp = temp/10 + (p.digit * n);
                q.next = new Node(temp%10);
                p = p.next;
                q = q.next;
            }
            if(temp>9)
                q.next = new Node(temp/10);
            return z;
        }
        public String toString(){
        StringBuffer buf = new StringBuffer(Integer.toString(start.digit));
        Node p = start.next;
        while(p!=null) {
            buf.insert(0, Integer.toString(p.digit));
            p=p.next;
        }
        return buf.toString();
    }

}
