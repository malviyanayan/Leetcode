import java.util.Stack;

class Leetcode71{
    public static void main(String[] args){
        // String str = "/home/user/Documents/../Pictures";
        // String str = "/home//foo/";
        // String str = "/../";
        // String str = "/a//b////c/d//././/..";
        // String str = "/.../a/../b/c/../d/./";
        // String str = "";
        // String str = "/a/b/c/d/e/../../../../x/";
        // String str = "/../../../../";
        // String str = "/a/b/c/";
        // String str = "/a/b/../../../c/";
        // String str = "./a/b/";
        // String str = "/a/b/..";
        // String str = "/a/./.././b/./c/..";
        // String str = "././././";
        String str = "/..hidden"; // this testcases is not pass in my code
        System.out.println(simplifyPath(str));
    }


    static String simplifyPath(String path) {
        Stack<Character> stk = new Stack<>();
        StringBuilder pt = new StringBuilder(path);

        while(pt.length() != 0){
            char ch = pt.charAt(0);
            
            // Rule Number - 1
            if(ch == '/' && stk.size()>0){
                char tp = stk.pop();
                if(tp != ch){
                    stk.push(tp);
                }
            }else if(ch == '.'){
                int dt = 0;
                while(pt.length() != 0 && pt.charAt(0) == '.'){
                    System.out.println(pt);
                    dt++;
                    pt.deleteCharAt(0);
                }
                System.out.println(pt);

                if(dt>2){
                    while(dt != 0){
                        stk.push(ch);
                        dt--;
                    }
                }else if(dt==1){
                    if(!stk.isEmpty())stk.pop();
                }else {
                    stk.pop();
                    while (!stk.isEmpty() && stk.pop() != '/');
                }

            }

            // Rule Number - 2
            if(ch == '.')stk.push('/');
            else stk.push(ch);
            if(pt.length()>0)pt.deleteCharAt(0);
            // System.out.println(stk);
        }
        
        if(stk.size()>1){
            char tp = stk.pop();
            if(tp != '/')stk.push(tp);
        }if(stk.size() == 0)stk.push('/');
        while(!stk.isEmpty())pt.insert(0, stk.pop());
        return new String(pt);
    }


    // ##### This is ChatGPT code
    // static String simplifyPath(String path) {
    //     Stack<String> stack = new Stack<>();
    //     String[] components = path.split("/");

    //     for (String component : components) {
    //         if (component.equals("..")) {
    //             // Go up one directory, if possible
    //             if (!stack.isEmpty()) stack.pop();
    //         } else if (!component.equals("") && !component.equals(".")) {
    //             // Add valid directory/file name
    //             stack.push(component);
    //         }
    //     }

    //     // Build the result from the stack
    //     StringBuilder result = new StringBuilder();
    //     for (String dir : stack) {
    //         result.append("/").append(dir);
    //     }

    //     return result.length() > 0 ? result.toString() : "/";
    // }
}