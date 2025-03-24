import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


class Leetcode1338 {
    public static void main(String[] args) {
        // int[] arr = {3,3,3,3,5,5,5,2,2,7};
        // int[] arr = {7,7,7,7,7,7};
        // int[] arr = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] arr = {1, 1, 1, 1, 1, 2};


        System.out.println(minSetSize(arr));
    }   
    
    
    static int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)->{
            return b.getValue().compareTo(a.getValue());
        });

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.add(entry);
        }
    
        int count = 0;
        int n = arr.length;
        while(queue.size() > 0){
            Map.Entry<Integer,Integer> entry = queue.remove();
            n = n - entry.getValue();
            count++;
            if(n <= arr.length/2)break;
        }
        return count;
    }
}
