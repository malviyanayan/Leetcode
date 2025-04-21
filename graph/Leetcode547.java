import java.util.LinkedList;
import java.util.Queue;

class Leetcode547 {

    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[n+1];
        
        for(int i=0;i<n;i++){
            if(visited[i])continue;
            count++;
            queue.add(i);
            visit(isConnected, visited, queue);
        }

        return count;
    }

    static void visit(int[][] isConnected,boolean[] visited, Queue<Integer> queue){
        while(!queue.isEmpty()){
            int i = queue.remove();
            if(visited[i])continue;
            
            visited[i] = true;
            for(int j = 0;j<isConnected.length;j++){
                if(isConnected[i][j] == 1)queue.add(j);
            }
        }
    }



    // Not Working correctly
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;

        boolean[] visited = new boolean[n+1];
        
        for(int i=0;i<n;i++){
            if(visited[i])continue;

            count++;
            for(int j = i-1;j>=0;j--){
                if(isConnected[i][j] == 1)visited[j] = true;
            }
            for(int j = i+1;j<n;j++){
                if(isConnected[i][j] == 1)visited[j] = true;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        
    }    
}
