
// Not Completed
class Leetcode493 {
    public static void main(String[] args) {

    }

    public int reversePairs(int[] nums) {

        int count = 0;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long temp = nums[j] *2;
                if(nums[i]>temp)count++;
            }
        }

        return count;
    }

}