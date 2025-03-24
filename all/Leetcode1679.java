import java.util.ArrayList;
import java.util.HashMap;

class Leetcode1679 {
    // static int maxOperations(int[] nums, int k) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     for(int i : nums){
    //         list.add(i);
    //     }
    //     int count = 0;

    //     while(find(list,k))count++;
    //     return count;
    // }   
    
    // static boolean find(ArrayList<Integer> list,int k){
    //     for(int i=0;i<list.size();i++){
    //         for(int j=i+1;j<list.size();j++){
    //             Integer f = list.get(i),l = list.get(j);
    //             if(f + l == k){
    //                 System.out.println(f + ", " + l);
    //                 list.remove(f);
    //                 list.remove(l);
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }


    static int maxOperations(int[] nums, int k) {
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(k-num)){
                count ++ ;
                map.put(k-num,map.getOrDefault(k-num, 0)-1);
                if(map.get(k-num)<1)map.remove(k-num);
            }else{
                map.put(num,map.getOrDefault(num, 0)+1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(maxOperations(arr,5));
    }
}
