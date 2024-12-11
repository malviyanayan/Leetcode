import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

class Leetcode2554 {
    public static void main(String[] args) {
        int[] banned = {1,6,5};
        int n = 5;
        int maxSum = 6;

        System.out.println(maxCount(banned, n, maxSum));
    }

    static int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        TreeSet<Integer> numbers = new TreeSet<>();
        for(int i = 1;i<=n;i++){
            numbers.add(i);
        }
        for(int num : banned){
            numbers.remove(num);
        }

        int count = 0;
        int sum = 0;
        for(int num : numbers){
            if(num+sum <= maxSum){
                sum+=num;
                count++;
            }else break;
        }
        return count;
    }
    
}
