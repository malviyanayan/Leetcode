class Leetcode67{

    public static String addBinary(String a, String b) {
        StringBuilder out = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            out.append(sum % 2); // Append remainder (0 or 1)
            carry = sum / 2; // Carry will be 1 if sum >= 2
        }

        return out.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        StringBuilder out = new StringBuilder();
        int i = a.length()- 1;
        int j = b.length() - 1;
        char carry = '0';

        while(i >= 0 && j >= 0){

            if(carry == '1'){
                if(a.charAt(i) == '1' && b.charAt(j) == '1'){
                    carry = '1';
                    out.insert(0, '1');
                }else if(a.charAt(i) == '0' && b.charAt(j) == '0'){
                    out.insert(0, '1');
                    carry = '0';
                }else{
                    out.insert(0, '0');
                    carry = '1';
                }
            }else{
                if(a.charAt(i) == '1' && b.charAt(j) == '1'){
                    carry = '1';
                    out.insert(0, '0');
                }else if(a.charAt(i) == '0' && b.charAt(j) == '0'){
                    out.insert(0, '0');
                    carry = '0';
                }else{
                    out.insert(0, '1');
                    carry = '0';
                }
            }

            i--;
            j--;
        }


        while(i >= 0){
            if(carry == '1'){
                if(a.charAt(i) == '1'){
                    out.insert(0, '0');
                    carry = '1';
                }else{
                    out.insert(0, '0');
                    carry = '0';
                }
            }else{
                out.insert(0, a.charAt(i));
            }

            i--;
        }

        while(j >= 0){
            if(carry == '1'){
                if(a.charAt(j) == '1'){
                    out.insert(0, '0');
                    carry = '1';
                }else{
                    out.insert(0, '1');
                    carry = '0';
                }
            }else{
                out.insert(0, a.charAt(j));
            }

            j--;
        }

        if(carry == '1')out.insert(0,'1');

        return new String(out);
    }

    
    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
    }
}