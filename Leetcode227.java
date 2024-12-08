import java.util.Stack;

class Leetcode227 {
    public static void main(String[] args) {
        // String str = "3+782*2";
        String str = "5*10+6-7*10/2";
        System.out.println(calculate(str));
    }

    // static int calculate(String s) {
    // Stack<String> stack = new Stack<>();
    // int i = 0;
    // int num = 0;
    // while(i<s.length()){
    // char ch = s.charAt(i);
    // if(ch == '+'){

    // }else if(ch == '-'){

    // }else if(ch == '*'){

    // }else if(ch == '/'){
    // String temp = ch.pop
    // }

    // i++;
    // }
    // return 0;
    // }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+'; // Initial sign is '+'

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build the current number
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If the character is an operator or it's the last character
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                // Update the sign and reset the number
                sign = ch;
                num = 0;
            }
        }

        // Sum up all values in the stack
        int result = 0;
        for (int n : stack) {
            result += n;
        }
        return result;
    }
}

