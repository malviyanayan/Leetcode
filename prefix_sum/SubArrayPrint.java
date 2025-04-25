class SubArrayPrint {

    static void printSubArrays(int[] arr){
        for (int i = 0; i < arr.length; i++) {       // i = starting point
            for (int j = i; j < arr.length; j++) {   // j = ending point
                // print subarray from i to j
                for (int k = i; k <= j; k++) {
                    System.out.println(arr[k]);
                }
                System.out.println();
            }
        }
        
    }


    public static void main(String[] args){
        int[] arr = {1,2,3};
        printSubArrays(arr);
    }
}
