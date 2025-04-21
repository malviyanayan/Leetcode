class Leetcode2145{

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int count = 0;
        int x = lower;

        while(x<=upper){
            int temp = x;
            int i = 0;
            for(i=0;i<differences.length;i++){
                temp += differences[i];
                if(temp < lower || temp > upper)break;
            }
            if(i == differences.length)count++;
            x++;
        }

        return count;
    }

    public static void main(String[] args){

    }
}