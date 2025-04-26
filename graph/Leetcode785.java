
class Leetcode785 {

    public boolean isBipartite(int[][] graph) {

        Boolean[] colored = new Boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!coloring(i, false, graph, colored, true))return false;
        }                           

        return true;
    }

    static boolean coloring(int i, boolean flag, int[][] graph, Boolean[] colored,boolean temp) {
        if(temp && colored[i] != null)return true;

        if (colored[i] == null) {
            colored[i] = flag;
            flag = !flag;
            for (int j = 0; j < graph[i].length; j++)
                if(!coloring(graph[i][j], flag, graph, colored, false))return false;
        }else{
            if(flag == colored[i])return true;
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }
}