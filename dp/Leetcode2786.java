import java.util.HashMap;

class Leetcode2786{

    public long maxScore(int[] nums, int x) {
        HashMap<String,Long> dp = new HashMap<>();
        boolean flag = false;
        if(nums[0] % 2 == 0)flag = true;
        return helper(nums, 1, nums[0], x, flag,dp);
    }

    static long helper(int[] nums,int i,long score,int x,boolean flag,HashMap<String,Long> dp){
        if(i >= nums.length)return score;

        String temp = i+","+score;
        if(dp.containsKey(temp))return dp.get(temp);

        long skip = helper(nums, i+1, score, x, flag, dp);

        if((nums[i]%2 == 0 && flag) || (nums[i] % 2 == 1 && !flag)){
            score += nums[i];
        }else{
            score+=nums[i];
            score = score - x;
        }

        if(nums[i]%2 == 1)flag = false;
        else flag = true;

        long take = helper(nums, i+1, score, x, flag, dp);

        dp.put(i+","+score, Math.max(skip,take));

        return Math.max(skip, take);
    }

    public static void main(String[] args){

    }
}