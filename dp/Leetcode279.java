class Leetcode279 {

    public int numSquares(int n) {
        return helper(n);
    }

    static int helper(int n){
        if(n/n == 1)return 1;

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            min = Math.min(min,1 + helper(min - i));
        }

        return min;
    }


    public static void main(String[] args){
        
    }    
}
