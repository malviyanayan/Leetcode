
class Leetcode3483 {

    static int totalNumbers(int[] digits) {
        int count = 0;

        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] % 2 == 0) {  
                int num = digits[i];
                digits[i] = -1; 
                count += helper(digits, 1);
                digits[i] = num; 
            }
        }

        return count;
    }

    static int helper(int[] digits, int x) {
        if (x == 3) return 1; 

        int count = 0;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == -1) continue; 

            
            if (x == 1 && digits[i] == 0) continue; 

            int num = digits[i];
            digits[i] = -1; 
            count += helper(digits, x + 1); 
            digits[i] = num; 
        }

        return count;
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4};
        System.out.println(totalNumbers(digits)); 
    }
}
