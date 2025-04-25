class Leetcode974{

    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        for(int next : nums)sum+=next;
        for(int i=0;i<nums.length;i++){
            int temp = sum;
            for(int j = nums.length-1; j >= i;j--){
                if(temp%k == 0)count++;
                temp = temp - nums[j];
            }
            sum = sum - nums[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,0,-2,-3,1};

    }
}