class LongestCommonSubstring{

    static int lcs(String a, String b){
        helper(a.length()-1,b.length()-1,a,b);
        return 0;
    }

    static int helper(int i,int j, String a, String b){

    }

    public static void main(String[] args) {
        String a = "abcdef", b = "defagh";
        System.out.println( "-----"+lcs(a, b));   
    }
}