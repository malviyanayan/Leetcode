import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Leetcode347{
    public static void main(String[] args) {
        
    }

    static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->{
            return a.getValue().compareTo(b.getValue());
        });

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(entry);
            if(pq.size()>k)pq.remove();
        }

        int[] ans = new int[pq.size()];
        int i=0;
        for(Map.Entry<Integer,Integer> entry : pq){
            ans[i++] = entry.getKey();
        }
        
        return ans;
    }
}