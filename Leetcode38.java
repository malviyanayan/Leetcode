// 38. Count and Say

class Leetcode38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(29));
    }

    static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        int count = 1;

        while(count++ < n){
            int i = 0;
            int temp = 1;
            while(i < sb.length()){
                if(i+1 != sb.length() && sb.charAt(i+1) == sb.charAt(i)){
                    temp++;
                    sb.deleteCharAt(i+1);
                }else{
                    sb.insert(i, temp);
                    temp = 1;
                    i+=2;
                }
            }
        }

        return new String(sb);
    }
    
}