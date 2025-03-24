import java.util.Stack;

public class Leetcode394 {
    public static void main(String[] args) {
        // String str = "3[a]2[bc]";
        String str = "3[a2[c]]";
        // String str = "2[abc]3[cd]ef";
        String ans = decodeString(str);
        System.out.println(ans);
    }    

    static String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        // System.out.println(sb);
        
        int i=0;
        helper(sb, i);
        return new String(sb);

        // String num = "";
        // String temp = "";
        // while(i<s.length()){
        //     char ch = s.charAt(i);
        //     if(ch >= 47 && ch <= 57){
        //         num+=ch;
        //     }else if(ch == '[' || ch == ']'){
        //         if(ch == ']'){
        //             int x = Integer.parseInt(num);
        //             while(x!=0){
        //                 sb.append(temp);
        //                 x--;
        //             }
        //             temp = "";
        //             num = "";
        //         }
        //     }else {
        //         temp += ch;
        //     }
        //     i++;
        // }

        // return new String(sb);
    }

    private static void helper(StringBuilder sb , int i){
        if(i>=sb.length())return;

        int s = i;
        while(i<sb.length()){
            char ch = sb.charAt(i);
            if(ch >= 48 && ch <= 57)break;
            i++;
        }

        if(i >= sb.length())return;

        
        String num = "";
        String temp = "";
        char ch = sb.charAt(i);
        while(i<sb.length() && ch >= 48 && ch<=57){
            num+=ch;
            i++;
            ch = sb.charAt(i);
        }

        ch = sb.charAt(i);
        if(ch == '['){
            i++;
            while(i<sb.length()){
                ch = sb.charAt(i);
                if(ch >= 48 && ch<=57){
                    helper(sb, i);
                    System.out.println(sb);
                }else if(ch == ']'){
                    break;
                }else{
                    temp += ch;
                }
                i++;
            }
        }

        sb.delete(s, i+1);
        int y = Integer.parseInt(num);
        while(y > 0){
            sb.insert(s,temp);
            y--;
        }

        
        i = s + temp.length()*Integer.parseInt(num);
        if(i<sb.length() && sb.charAt(i)==']')i++;
        // System.out.println(sb);
        // System.out.println(i);
        // System.out.println(sb.length());
        helper(sb, i);
    }

    static String decodeString1(String s) {
        // this code is from chatgpt
        Stack<String> stringStack = new Stack<>(); //
        Stack<Integer> countStack = new Stack<>(); 
        String currentString = ""; 
        int currentNumber = 0; 

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) { 
                currentNumber = currentNumber * 10 + (ch - '0');
            } else if (ch == '[') { 
                countStack.push(currentNumber); 
                stringStack.push(currentString); 
                currentString = ""; 
                currentNumber = 0; 
            } else if (ch == ']') { 
                int repeatCount = countStack.pop(); 
                StringBuilder temp = new StringBuilder(stringStack.pop()); 
                for (int i = 0; i < repeatCount; i++) {
                    temp.append(currentString); 
                }
                currentString = temp.toString(); 
            } else { 
                currentString += ch;
            }
        }

        return currentString;
    }
}
