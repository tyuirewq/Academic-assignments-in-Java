package code.Java;

import java.util.*;

public class homework10 {
// this for postfix evaluation
    static int postfix(String expression) {
        // here we are creatng a stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c))
                stack.push(c - '0');
            else {
                int value = stack.pop();
                int nextValue = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(value + nextValue);
                        break;
                    case '-':
                        stack.push(nextValue - value);
                        break;
                    case '*':
                        stack.push(value * nextValue);
                        break;
                    case '/':
                        stack.push(nextValue / value);
                        break;
                }
            }

        }
        return stack.pop();
    }
// to identify the precedance of the operator
    static int Precedance(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
// to convert infix expression to postfix 
    static String InfixtopostFix(char[] c) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; ++i) {
            char ch = c[i];
            if (Character.isLetterOrDigit(ch))
                result += ch;
            else if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && Precedance(ch) <= Precedance(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }
// to reverse the letters of the word
    static String reverse(char str[], int First, int Last) {
        char temp;
        while (First < Last) {
            temp = str[First];
            str[First] = str[Last];
            str[Last] = temp;
            First++;
            Last--;
        }
        return String.copyValueOf(str);
    }
//  to convert infix expression to prefix 
    static String infixtoprefix(char[] c) {
        String c1 = reverse(c, 0, c.length - 1);
        c = c1.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                c[i] = ')';
                i++;
            } else if (c[i] == ')') {
                c[i] = '(';
                i++;
            }
        }
        String prefix = InfixtopostFix(c);
        System.out.println(prefix);
        prefix = reverse(prefix.toCharArray(), 0, c.length - 1);
        return prefix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter your Expression For Postfix Evaluation :     ");
        System.out.println();
        String expression = sc.nextLine();
        System.out.println();
        System.out.println();
        System.out.println("Your postfix evaltion is :    " + postfix(expression));
        System.out.println();
        System.out.println("Enter your Infix Expression For Postfix Expression :     ");
        System.out.println();
        String expt = sc.nextLine();
        System.out.println();
        System.out.println("Your Postfix Expression From Infix expression:    " + InfixtopostFix(expt.toCharArray()));
        System.out.println();
        System.out.println("Enter your Infix Expression For Prefix Expression :     ");
        System.out.println();
        String expr = sc.nextLine();
        System.out.println("Your Prefix Expression From Infix expression:    " + infixtoprefix(expr.toCharArray()));
        sc.close();
    }
}


//Hariom Kaushal
//202051080