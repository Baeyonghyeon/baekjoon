package coplet;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        boolean output = balancedBrackets("(");
        System.out.println(output); // // -> false

        output = balancedBrackets("()");
        System.out.println(output); // --> true

        boolean output2 = balancedBrackets("[](){}");
        System.out.println(output2); // --> true

        boolean output3 = balancedBrackets("[({})]");
        System.out.println(output3); // --> true

        boolean output4 = balancedBrackets("[(]{)}");
        System.out.println(output4); // --> false
    }

    public static boolean balancedBrackets(String str) {
        if (str.length() == 0) {
            return true;
        }

        if (str.length() % 2 == 1) {
            return false;
        }

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')') {
                if (!stack.empty() && (stack.peek() == '(')) {
                    stack.pop();
                } else {
                    return false;
                }
            }

            if (c == ']') {
                if (!stack.empty() && (stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }

            if (c == '}') {
                if (!stack.empty() && (stack.peek() == '{')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
