
public class RPN {
    String  postfix(String infix) {
        Double value;
        boolean endOfNumber = false;
        String postfixExp = new String();
        ArrayStack stk = new ArrayStack(infix.length());

        for(int i = 0; i < infix.length(); i++)
        {
            switch(infix.charAt(i))
            {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    postfixExp = postfixExp.concat(infix.charAt(i)+"");
                    endOfNumber = true;
                    break;

                case '(':
                    if(endOfNumber == true)  {
                        postfixExp = postfixExp.concat(" ");
                        endOfNumber = false;
                    }

                    stk.push(new Character('('));
                    break;

                case ')':
                    if(endOfNumber == true)  {
                        postfixExp = postfixExp.concat(" ");
                        endOfNumber = false;
                    }
                    while(((Character)stk.peek()).charValue() != '(' )
                        postfixExp = postfixExp.concat(((Character)stk.pop()).toString());
                    Object openParen = stk.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    if(endOfNumber == true)  {
                        postfixExp = postfixExp.concat(" ");
                        endOfNumber = false;
                    }

                    while ( !stk.isEmpty() && ((Character)stk.peek()).charValue() != '('
                            &&  getPrec(infix.charAt(i)) <= getPrec(((Character)stk.peek()).charValue()) )  {
                        postfixExp = postfixExp.concat(((Character)stk.pop()).toString());
                    }
                    stk.push(new Character(infix.charAt(i)));
                    break;
            }
        }

        if(endOfNumber == true) {
            postfixExp = postfixExp.concat(" ");
            endOfNumber = false;
        }

        while( !stk.isEmpty()) {
            postfixExp = postfixExp.concat(((Character)stk.pop()).toString());
        }

        System.out.println(postfixExp);

        return postfixExp;
    }

    Double result(String postfixExp) {
        Double value, buffer;
        String temp = new String();
        ArrayStack stk = new ArrayStack(postfixExp.length());

        for(int i=0; i<postfixExp.length(); i++)    {
            switch(postfixExp.charAt(i))    {

                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    temp = temp.concat(postfixExp.charAt(i)+"");
                    System.out.println(postfixExp.charAt(i)+ "... push");
                    break;
                case ' ':
                    stk.push(new Double(temp));

                    temp = new String();
                    break;
                case '+':
                    System.out.println(postfixExp.charAt(i)+ "... pop");
                    System.out.println(stk.peek() +" + "+ stk.peeksecond()+" = "+((Double)stk.peek()+(Double)stk.peeksecond())+"....push");
                    value = new Double(((Double)stk.pop()).doubleValue() + ((Double)stk.pop()).doubleValue());

                    stk.push(value);
                    break;
                case '-':
                    System.out.println(postfixExp.charAt(i)+ "... pop");
                    System.out.println(stk.peeksecond() +" - "+ stk.peek()+" = "+((Double)stk.peek()-(Double)stk.peeksecond())+"....push");
                    buffer = new Double(((Double)stk.pop()).doubleValue());
                    value = new Double(((Double)stk.pop()).doubleValue() - buffer.doubleValue());
                    stk.push(value);
                    break;
                case '*':
                    System.out.println(postfixExp.charAt(i)+ "... pop");
                    System.out.println(stk.peek() +" * "+ stk.peeksecond()+" = "+((Double)stk.peek()*(Double) stk.peeksecond())+"....push");
                    value = new Double(((Double)stk.pop()).doubleValue() * ((Double)stk.pop()).doubleValue());
                    stk.push(value);
                    break;
                case '/':
                    System.out.println(postfixExp.charAt(i)+ "... pop");
                    System.out.println(stk.peek() +" / "+ stk.peeksecond()+" = "+((Double)stk.peek()/(Double) stk.peeksecond())+"....push");
                    buffer = new Double(((Double)stk.pop()).doubleValue());
                    value = new Double(((Double)stk.pop()).doubleValue() / buffer.doubleValue());
                    stk.push(value);
                    break;
            }
        }
        return (Double)stk.peek();
    }

    int getPrec(char op) {
        int prec = 0;
        switch (op)  {
            case '+':
            case '-':
                prec = 1;
                break;
            case '*':
            case '/':
                prec = 2;
                break;
        }
        return prec;
    }
}

