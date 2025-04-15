class Leetcode1025{

    public boolean divisorGame(int n) {
        return helper(n, false);
    }

    static boolean helper(int n, boolean flag){
        if(n == 1)return flag;
        return helper(n-(n/2), flag ? false : true);
    }


    public static void main(String[] args){

    }
}