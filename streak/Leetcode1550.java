class Leetcode1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        // Loop through the array up to length - 2
        for (int i = 0; i < arr.length - 2; i++) {
            // Check if arr[i], arr[i+1], and arr[i+2] are all odd
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true; // Found three consecutive odd numbers
            }
        }
        return false; // No such sequence found
    }    
}
