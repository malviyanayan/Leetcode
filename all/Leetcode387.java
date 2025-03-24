import java.util.HashMap;

public class Leetcode387 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }

    static int firstUniqChar(String s) {
        HashMap<Character,Integer[]> map = new HashMap<>();
        int index = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int val = 1;
            if(map.containsKey(ch)){
                val = map.get(ch)[0]+1;
            }

            map.put(ch, new Integer[]{val,index++});

        }

        int ans = -1;

        for(char key : map.keySet()){
            if(map.get(key)[0]==1){
                int temp = map.get(key)[1];
                if(ans==-1)ans=temp;
                else if(ans>temp)ans = temp;
            }
        }

        // for(char key : map.keySet()){
        //     System.out.println("[" + key + "," + map.get(key)[0] + "," + map.get(key)[1] + "," + "]");
        // }
        char ch = s.charAt(ans);
       return ans; 
    }
}
