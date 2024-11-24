import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Leetcode658 {
    public static void main(String[] args) {
        // int[] arr = {0,2,5,6,8,12};
        // int k = 3;
        // int x = 0;

        // int[] arr = {1,2,3,4,5};
        // int k = 4;
        // int x = 3;



        // int[] arr = {1,1,2,3,4,5};
        // int k = 4;
        // int x = -1;



        // int[] arr = {1, 2, 3, 4, 5};
        // int k = 2;
        // int x = 6;


        // int[] arr = {1, 1, 1, 10, 10, 10};
        // int k = 1;
        // int x = 5;


        // int[] arr = {1, 2, 3, 4, 5};
        // int k = 5;
        // int x = -1;


        int[] arr = {10, 20, 30, 40, 50};
        int k = 3;
        int x = 35;


        // int[] arr = {1,1,1,10,10,10};
        // int k = 1;
        // int x = 9;


        // int[] arr = {1,25,35,45,50,59};
        // int k = 1;
        // int x = 30;


        ArrayList<Integer> list = findClosestElements1(arr, k, x);
        System.out.println("answer is : " + list);
    }  

    static ArrayList<Integer> findClosestElements1(int[] arr,int k,int x){
        PriorityQueue<Pair> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int item : arr){
            int diff = Math.abs(x - item);
            queue.add(new Pair(diff, item));
            if(queue.size()>k)queue.remove();
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(queue.size() != 0){
            list.add(queue.remove().ele);
        }

        Collections.sort(list);
        return list;
    }

    
    static ArrayList<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0,r = arr.length-1;
        int mid = -1;
        while(l<=r){
            mid = r-(r-l)/2;
            if(arr[mid] == x)break;
            else if(arr[mid]>x)r = mid - 1;
            else l = mid + 1;
        }
        System.out.println(mid);

        if(arr[mid]==x){
            // System.out.println("~~~~"+arr[mid]);
            l = mid-1;
            r = mid;
        }else{
            if(arr.length%2 == 0)mid++;
            l = mid-1;
            r = mid;
        }
        
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<k;i++){
            int ld = Integer.MAX_VALUE;
            if(l != -1)ld = x-arr[l];

            int rd = Integer.MAX_VALUE;
            if(r != arr.length)rd = arr[r]-x;

            
            if(ld <= rd){
                list.add(0,arr[l]);
                l--;
            }else{
                list.add(arr[r]);
                r++;
            }
        }

        return list;
    }

}


class Pair implements Comparable<Pair>{
    Integer diff;
    Integer ele;

    Pair(int diff,int ele){
        this.diff = diff;
        this.ele = ele;
    }

    public int compareTo(Pair pair){
        if(this.diff == pair.diff)return this.ele - pair.ele;
        return this.diff - pair.diff;
    }

}