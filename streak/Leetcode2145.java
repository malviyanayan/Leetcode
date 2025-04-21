class Leetcode2145{

    public int numberOfArrays1(int[] differences, int lower, int upper) {
        long sum = 0;
        long min = 0, max = 0;

        for (int diff : differences) {
            sum += diff;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        // Calculate the valid range for starting value
        long minStart = lower - min;
        long maxStart = upper - max;

        return (int)Math.max(0, maxStart - minStart + 1);
    }

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