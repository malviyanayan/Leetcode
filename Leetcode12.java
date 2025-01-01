import java.util.ArrayList;
import java.util.HashMap;

class Leetcode12{
    public static void main(String[] args) {
        int i = 3749;
        intToRoman(i);
    }

    private static HashMap<Integer,Character> map = new HashMap<>();
    
    static{
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
    }

    // 3749
    static String intToRoman(int num) {
        ArrayList<Integer> temp = new ArrayList<>();
        String ans = "";
        int i = 0;
        while(num != 0){
            int rem = num%10;
            temp.add(0, rem*(int)Math.pow(10, i));
            i++;
            num = num/10;
        }

        for(int next : temp){

        }

      return ans;  
    }

}