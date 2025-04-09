import java.util.HashMap;
import java.util.Map;

class Leetcode279 {

    static Map<Integer, Integer> memo = new HashMap<>();

    static int numSquares(int n) {
        if (n < 1) return 0;
        if (memo.containsKey(n)) return memo.get(n);

        int x = (int)Math.sqrt(n);
        if (x * x == n) return 1;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, numSquares(n - i * i) + 1);
        }

        memo.put(n, min);
        return min;
    }

    

    public static void main(String[] args){
        int x = 12;
        System.out.println("Squeres is : " + numSquares(x));
    }    
}
