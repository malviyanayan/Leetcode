
// 973. K Closest Points to Origin

import java.util.PriorityQueue;
import java.util.Collections;

public class Leetcode973{
    public static void main(String[] args) {
        // int[][] arr = {{1,3},{-2,2}};
        // int k = 1;
        // int[][] arr = {{3,3},{5,-1},{-2,4}};
        // int k = 2;
        int[][] arr = {};
        int k = 2;
        int[][] ans = kClosest(arr, k);

        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i][0] + "," + ans[i][1]);
        }

    }
    
    static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<points.length;i++){
            double temp = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            queue.add(new Point(temp, i));
            if(queue.size()>k)queue.remove();
        }

        int[][] ans = new int[queue.size()][2];
        int i=0;
        while(queue.size() != 0){
            Point p = queue.remove();
            ans[i++] = points[p.idx];
        }
        return ans;
    }
}

class Point implements Comparable<Point>{
    Double dist;
    Integer idx;

    public Point(double dist, int idx) {
        this.dist = dist;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point o) {
        return dist.compareTo(o.dist);
    }

}