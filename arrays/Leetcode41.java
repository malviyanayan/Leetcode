import java.util.HashSet;

class Leetcode41 {
    // Simple approach
    static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Convert all non-positive numbers to a valid range (n+1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;  // Out of range number
            }
        }

        // Step 2: yadi number 1 se n ke beech ho to unhe negative mark ker do
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);  // positive number lo
            
            if (val >= 1 && val <= n) {
                int index = val - 1;
                if (nums[index] > 0) {
                    nums[index] = -nums[index];  // Mark negative
                }
            }
        }

        // Step 3: tab tak aage badho jab tak negative mil rha
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;  // Found missing number
            }
        }

        return n + 1;  // If all numbers from 1 to n are present
    }


    // tc-0(n),sc-o(n) //that is not good method
    static int firstMissingPositive1(int[] nums) {
        int missing = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int next : nums){
            // go left to right 
            // if current number is missing //increse missing number
            if(next == missing){
                missing++;
            }else{
                if(set.contains(missing))missing++;
                set.add(next);
            }
            // else current number store in the hashset and continue
        }

        while(set.contains(missing))missing++;

        return missing;
    }

    public static void main(String[] args){
        // int[] arr = {1,2,0};
        // int[] arr = {7,8,9,11,12};
        int[] arr = {100000, 3, 4000, 2, 15, 1, 99999};
        System.out.println(firstMissingPositive(arr));
    }    
}
