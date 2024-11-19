class Leetcode1011 {
    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // int days = 5;
        // int[] arr = {3,2,2,4,1,4};
        // int days = 3;
        int[] arr = {1,2,3,1,1};
        int days = 4;
        System.out.println(shipWithinDays(arr, days));
    }

    static int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            if(min>weights[i])min = weights[i];
        }
        int lo = min,hi = sum,minC = hi;

        while(lo<=hi){
            int mid = hi - (hi - lo)/2;
            if(isCorrect(mid,weights,days)){
                minC = mid;
                hi = mid - 1;
            }else lo = mid + 1;
        }

        return minC;
    }

    static private boolean isCorrect(int c,int[] arr,int days){
        int load = 0,d = 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>c)return false;
            if(load + arr[i] <= c){
                load += arr[i];
            }else{
                load = arr[i];
                d++;
            }
        }

        if(d>days)return false;
        return true;
    }
    
}
