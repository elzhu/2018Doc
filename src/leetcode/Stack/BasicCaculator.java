package leetcode.Stack;

import java.util.Stack;

public class BasicCaculator {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // number * 10 for 16/166/1666 and c - '0' means the actually number
                number = number * 10 + (int) (c - '0');
            } else if (c == '+') {
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += number * sign;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                //reset result and sign
                result = 0;
                sign = 1;

            } else if (c == ')') {
                result += number * sign;
                // first pop is sign, and second one is last result
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }
        }
        if (number != 0) {
            result += number * sign;
        }
        return result;
    }

    public static int calculatex(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        Character sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (int) (c - '0');
            }

            if ((!Character.isDigit(c) && ' ' != s.charAt(i)) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(number);
                    number = 0;
                } else if (sign == '-') {
                    stack.push(-number);
                    number = 0;
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = c;
                number = 0;
            }
        }
        for (int i : stack) {
            result += i;
        }
        return result;
    }

    public static int calculateThree(String s) {
        int result = 0;
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                number  = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    number = number * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                numbers.push(number);
                number = 0;

            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // do the math when we encounter a ')' until '('
                while (ops.peek() != '(') {
                    numbers.push(opeartion(ops.pop(), numbers.pop(), numbers.pop()));
                }
                //finsihed math and get ride of (''
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while(!ops.isEmpty() && precedence(c, ops.peek())) {
                    numbers.push(opeartion(ops.pop(), numbers.pop(), numbers.pop()));
                    ops.push(c);
                }
            }
        }
        while (!ops.isEmpty()) {
            numbers.push(opeartion(ops.pop(), numbers.pop(), numbers.pop()));
        }
        return numbers.pop();
    }

    public static int opeartion(char op, int b, int a) {
        switch (op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            // assume b != 0
            case '/' : return a / b;

        }
        return 0;
    }

    public static boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        String s1 = "(4-5-2)-3+(6-8)";
        String s2 = "(1+4+5+2-3)+(6-8)";
        String s3 = "1+4+5";
        String s4 = "3 + 3 / 5 - 3 * 1 + 9";

        System.out.println(calculate(s3));
        System.out.println(calculatex(s4));
    }
}
