import java.util.Stack;

class Leetcode1910 {

    static String removeOccurrences1(String s, String part) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));

            if(stack.peek() == part.charAt(part.length() - 1)){
                Stack<Character> stk1 = new Stack<>();
                int n = part.length() - 1;
                while(n >= 0 && !stack.isEmpty() && stack.peek() == part.charAt(n)){
                    stk1.push(stack.pop());
                    n--;
                }

                if(n == -1){
                    continue;
                }else{
                    while(!stk1.isEmpty()){
                        stack.push(stk1.pop());
                    }
                } 
            }

        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
    
    static String removeOccurrences2(String s, String part) {
        while(s.contains(part)){
            s = s.replaceFirst(part,"");
        }
        
        return s;
    }
    
    static String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int index;
        
        while ((index = sb.indexOf(part)) != -1) {
            sb.delete(index, index + part.length());
        }
        
        return sb.toString();
    }

    public static void main(String[] args){
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences(s, part));

    }
}
