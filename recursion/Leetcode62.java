class Leetcode62{

    static int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }

    static int helper(int c1, int c2, int m, int n){
        if(c1 == m-1 && c2 == n-1)return 1;

        int total = 0;
        // go right
        if(c1 != m-1){
            total = helper(c1+1, c2, m, n);
        }

        if(c2 != n-1){
            total += helper(c1, c2+1, m, n);
        }

        // go left

        return total; 
    }

    public static void main(String[] args) {
        
    }
}