import java.util.LinkedList;
import java.util.Queue;

class Leetcode1971{
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(source);

        while(!queue.isEmpty()){
            int next = queue.remove();
            
            if(visited[next])continue;
            visited[next] = true;
            for(int temp : edges[next]){
                System.out.print(temp+",");
                if(temp == destination)return true;
                queue.add(temp);
            }
        }

        return false;
    }                                               

    public static void main(String[] args) {
        
    }
}