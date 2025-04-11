class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        return helper(coins, 0, 0, amount);
    }

    private static int helper(int[] coins,int i,int current,int amount){
        if(amount == 0)return current;
        if(amount < 0 || coins.length == i)return Integer.MAX_VALUE;

        
        int skip = helper(coins, i+1, current, amount);
        int take = helper(coins, i, current+1, amount-coins[i]);

        return Math.min(skip,take);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(helper(coins, 0, 0, amount));
    }

}
