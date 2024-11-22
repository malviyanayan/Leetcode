// 215. Kth Largest Element in an Array

import java.util.PriorityQueue;

public class Leetcode215{
    public static void main(String[] args){
        // int[] arr = {3,2,1,5,6,4};
        // int k = 2;
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }

    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size()>k)pq.remove();
        }
        return pq.peek();
    }
}