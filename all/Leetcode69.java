class Leetcode69{
    public static void main(String... args){
        System.out.println(sqrt(15));
    }


    static int sqrt(int x){
        int sqrt = 0;
        int s=1,e=x-1;
        int mid = (s+e)/2;
        while (s<=e) {
            mid = (s+e)/2;
            if(mid*mid == x)return mid;
            else if(mid * mid > x)e=mid-1;
            else {
                sqrt = mid;
                s = mid + 1;
            }
        }
        return sqrt;
    }
}