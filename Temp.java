public class Temp {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abcde");
        // System.out.println(str);


        str.insert(0, 2);
        // str.deleteCharAt(2);
        System.out.println(str);



        // for(int i=0;i<str.length();i++){
        //     if(str.charAt(i)=='0')str = str.insert(i+1, '1');
        //     else if(str.charAt(i) == '1')str = str.insert(i+1,'0');
        //     i++;
        // }

        // for(int i=0;i<str.length();i++){
        //     System.out.println(str.charAt(i));
        // }
        
    }
}
