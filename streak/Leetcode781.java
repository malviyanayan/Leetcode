import java.util.HashMap;

class Leetcode781{

    public static void main(String[] args){

    }

    public int numRabbits(int[] answers) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ans : answers){
            ans += 1;
            if(map.containsKey(ans)){
                int rabCounts = map.get(ans);
                if(rabCounts % ans == 0){
                    count += ans;
                }
                map.put(ans,rabCounts+1);
            }else{
                map.put(ans,1);
                count += ans;
            }
        }

        return count; 
    }

}