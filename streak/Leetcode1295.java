class Leetcode1295 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int next : nums)if(isEven(next))count++;
        return count;
    }

    boolean isEven(int next){
        boolean flag = true;
        while(next != 0){
            next/=10;
            flag = !flag;
        }
        return flag;
    }
}