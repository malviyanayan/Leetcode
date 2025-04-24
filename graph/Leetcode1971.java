import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Leetcode1971{

    static List<List<Integer>> edgesToAdjacencyList(int[][] edges,int n){
        List<List<Integer>> list = new ArrayList<>(n);

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        return list;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> list = edgesToAdjacencyList(edges, n);
        
        boolean[] visited = new boolean[n];
        queue.add(source);

        while(!queue.isEmpty()){
            int next = queue.remove();
            
            if(visited[next])continue;
            visited[next] = true;
            for(int temp : list.get(next)){
                if(temp == destination)return true;
                queue.add(temp);
            }
        }

        return false;
    }                                               

    public static void main(String[] args) {
        
    }
}