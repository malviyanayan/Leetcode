class GeeksSort012 {
    public static void sort012(int[] arr) {
        int low = 0, mid = 0, hi = arr.length - 1;

        while(mid<hi){
            if(arr[low] == 0){
                low++;
                if(low > mid)mid = low;
            }else if(arr[hi] == 2){
                hi--;
            }else if(arr[mid] < arr[low]){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
            }else if(arr[mid] > arr[hi]){
                int temp = arr[hi];
                arr[hi] = arr[mid];
                arr[mid] = temp;
            }else mid++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        sort012(arr);

        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }    
}
