class Leetcode319{
    public static void main(String[] args){
        System.out.println("jai ho");
        // int x = 3;
        // int x = 0;
        int x = 1;
        System.out.println(bulbSwitch(x));
    }

    // static int bulbSwitch(int n) {
    //     if(n<=1)return n;

    //     boolean[] bulbs = new boolean[n];
    //     for(int i = 0;i<n;i++)bulbs[i] = true;

    //     int i = 2;
    //     while(i<=n){
    //         for(int j=i-1;j<n;j+=i){
    //             if(bulbs[j])bulbs[j]=false;
    //             else bulbs[j] = true;
    //         }
    //         i++;
    //     }

    //     int ans = 0;
    //     for(boolean next : bulbs){
    //         if(next)ans++;
    //     }
    //  return ans;   
    // }



    // Updated Version.......
    static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}