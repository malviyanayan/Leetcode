import java.util.ArrayList;
import java.util.HashMap;
// import java.util.ArrayList;

public class LeetCode2094 {
    public static void main(String[] args) {
        int[] digits = {2,1,3,0};

        int[] ans = findEvenNumbers(digits);

        System.out.print("Your Array Is : ");
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i] + ", ");
        }

        System.out.println();
    }
    
    static int[] findEvenNumbers(int[] digits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : digits)map.put(i,map.getOrDefault(i, 0) + 1);

        for(int i=100;i<999;i=i+2){
            int x = i;

            int c = x%10;x/=10;
            int b = x%10;x/=10;
            int a = x%10;x/=10;
            if(map.containsKey(a)){
                int aFreq = map.get(a);
                map.put(a, aFreq-1);
                if(aFreq==1)map.remove(a);

                if(map.containsKey(b)){
                    int bFreq = map.get(b);
                    map.put(b, bFreq-1);
                    if(bFreq == 1)map.remove(b);

                    if(map.containsKey(c)){
                        ans.add(i);
                    }

                    map.put(b, bFreq);
                }

                map.put(a, aFreq);
            }
        }

        int[] ans1 = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ans1[i] = ans.get(i);
        }

        return ans1;
    }
}