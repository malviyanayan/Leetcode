import java.util.PriorityQueue;
import java.util.Collections;

class Leetcode1046 {
    public static void main(String[] args) {
        // int[] stones = {2,7,4,1,8,1};
        // int[] stones = {1};
        // int[] stones = {0, 10, 5, 5};
        int[] stones = {1000, 500, 250, 125, 60, 30, 15};
        System.out.println(lastStoneWeight(stones));
    }



    static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            queue.add(stone);
        }

        while(queue.size()>1){
            int y = queue.remove();
            int x = queue.remove();
            if(x!=y)queue.add(y-x);
        }

        if(queue.size()==1)return queue.remove();
        return 0;
    }
    
}
