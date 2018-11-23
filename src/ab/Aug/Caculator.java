package ab.Aug;

import java.util.Stack;

public class Caculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (int)(c - '0');
            } else if (c == '+') {
                result += number * sign;
                sign = 1;
                number = 0;
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
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }

    public static int calculate2(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            if (!Character.isDigit(c)) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        for (int i : stack) {
            result += i;
        }
        return result;
    }
    public static void main(String [] args) {
       String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("-------calculate : " + calculate(s));

    }
}
