import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.util.Arrays;

class Leetcode2915{

    static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target + 1];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        int temp = helper(nums, 0 , 0, target,dp)-1;
        return temp;
    }

    static int helper(List<Integer> nums, int i, int current, int target,int[][] dp){
        if(i >= nums.size()){
            if(target == current)return 1;
            else return 0;
        }

        if (dp[i][current] != -1) {
            return dp[i][current];
        }

        int skip = helper(nums, i + 1,current, target,dp);
        if(current + nums.get(i) > target)return skip;

        int take = helper(nums, i + 1,current + nums.get(i),target,dp);

        if(take != 0)take++;

        if(take > skip)dp[i][current] = take;
        else dp[i][current] = skip;
        
        return Math.max(skip, take);
    }
    
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        List<Integer> list = new ArrayList<>();
        for(int next : nums){
            list.add(next);
        }
        int target = 9;

        lengthOfLongestSubsequence(list, target);
    }
}