class Leetcode779 {
    

    
    // static int kthGrammar(int n, int k) {
    //     StringBuilder str = new StringBuilder("0");
    //     for(int j=1;j<n;j++){
    //         for(int i=0;i<str.length();i++){
    //             if(str.charAt(i)=='0')str = str.insert(i+1, '1');
    //             else if(str.charAt(i) == '1')str = str.insert(i+1,'0');
    //             i++;
    //         }
    //     }

    //     return Integer.parseInt(str.charAt(k-1)+"");
    // }

    // Code start from here

    static int kthGrammar(int n, int k) {
        
    }

    static String getString(int n){
        if(n==1)return "0";
        StringBuilder str = ;
        
    }

    public static void main(String[] args) {
        // int ans = kthGrammar(1, 1);
        // int ans = kthGrammar(2, 1);
        // int ans = kthGrammar(2, 2);
        // int ans = kthGrammar(3, 2);
        // int ans = kthGrammar(4, 3);// wrong
        // int ans = kthGrammar(4, 5);
        // int ans = kthGrammar(0, 0);
        int ans = kthGrammar(5, 8);
        System.out.println("Answer is : " + ans);
    }
}