import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Leetcode841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.add(0);
        visit(queue,rooms,visited);
        for (boolean b : visited)if(!b)return false;
        return true;
    }

    static void visit(Queue<Integer> queue,List<List<Integer>> rooms,boolean[] visited){
        while(!queue.isEmpty()){
            int next = queue.remove();
            if(visited[next])continue;
            visited[next] = true;
            for(int temp : rooms.get(next)){
                queue.add(temp);
            }
        }
    }

    public static void main(String[] args) {
        
    }
}