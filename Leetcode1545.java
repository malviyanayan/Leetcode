class Leetcode1545{
    public static void main(String[] args){
        System.out.println(findKthBit(3, 1));
        System.out.println(findKthBit(4, 11));
    }

    static char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb = helper(sb, n);
        return sb.charAt(k-1);
    }

    private static StringBuilder helper(StringBuilder sb, int n){
        if(n<=1)return new StringBuilder("0");

        sb = helper(sb, n-1);
        StringBuilder temp = revert(sb);
        temp = temp.reverse();
        sb.append("1");
        sb.append(temp);
        return sb;
    }

    private static StringBuilder revert(StringBuilder sb){
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1')temp.append('0');
            else temp.append("1");
        }
        return temp;
    }
}