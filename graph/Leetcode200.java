import java.util.LinkedList;
import java.util.Queue;

class Leetcode200 {

    // ################################
    
    static void dfs(int i, int j, char[][] grid){
        if(grid[i][j] == 'x' || grid[i][j] == '0')return;
        
        grid[i][j] = 'x';
        if((j+1) < grid[0].length)dfs(i, j+1, grid);
        if((i+1) < grid.length)dfs(i+1, j, grid);
        if((i-1) >= 0)dfs(i-1, j, grid);
        if((j-1) >= 0)dfs(i, j-1, grid);
    }

    public int numIslands2(char[][] grid) {
        int count = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }


    
    // ################################
    // by bfs
    static void bfs(char[][] grid,Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] next = queue.remove();
            int i=next[0],j = next[1];
            
            grid[i][j] = 'x';
            if((j+1) < grid[0].length && grid[i][j+1] == '1')queue.add(new int[]{i, j+1});
            if((i+1) < grid.length && grid[i+1][j] == '1')queue.add(new int[]{i+1, j});
            if((i-1) >= 0 && grid[i-1][j] == '1')queue.add(new int[]{i-1, j});
            if((j-1) >= 0 && grid[i][j-1] == '1')queue.add(new int[]{i, j-1});
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        Queue<int[]>queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    queue.add(new int[]{i, j});
                    bfs(grid, queue);
                }
            }
        }

        return count;
    }




    // ############## Improved ###############
    static void bfs1(char[][] grid,Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] next = queue.remove();
            int i=next[0],j = next[1];
            if(grid[i][j] == 'x' || grid[i][j] == '0')continue;
            grid[i][j] = 'x';
            if((j+1) < grid[0].length)queue.add(new int[]{i, j+1});
            if((i+1) < grid.length)queue.add(new int[]{i+1, j});
            if((i-1) >= 0)queue.add(new int[]{i-1, j});
            if((j-1) >= 0)queue.add(new int[]{i, j-1});
        }
    }

    public int numIslands1(char[][] grid) {
        int count = 0;
        Queue<int[]>queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    queue.add(new int[]{i, j});
                    bfs(grid, queue);
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        
    }    
}
