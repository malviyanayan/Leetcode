import java.util.HashMap;

class Leetcode1399 {

    public int countLargestGroup(int n) {
        if(n<10)return n;

        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=1;i<=n;i++){
            int x = getNum(i);
            map.put(x,map.getOrDefault(x, 0)+1);
        }

        int large = -1;

        for(java.util.Map.Entry<Integer,Integer> entry : map.entrySet()){
            if((int)entry.getValue() > large)large = (int)entry.getValue();
        }

        for(java.util.Map.Entry<Integer,Integer> entry : map.entrySet())if((int)entry.getValue() == large)count++;

        return count;
    }

    static int getNum(int x){
        while(x > 9){
            int sum = 0;
            while(x != 0){
                sum += x%10;
                x/=10;
            }
            x = sum;
        }

        return x;
    }

    public static void main(String[] args) {
        
    }    
}
