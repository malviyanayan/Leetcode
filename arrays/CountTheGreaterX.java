// Count the number of elements strictly greater than x.

class CountTheGreaterX {
    
    // GFG Question

    static int countGreater(int[] arr,int x){
        int diff = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+diff >= x){
                count++;
                diff--;
            }else{
                diff++;
            }

            for(int next : arr){
                System.out.print(next + ", ");
            }
    
            System.out.println();
        }
        return count;
    }


    public static void main(String[] args) {
//         Input: arr[] = {10, 5, 5, 4, 9}, X = 10 
//         Output: 2



        int[] arr = {10, 5, 5, 4, 9};
        int x = 10;

        System.out.println(countGreater(arr,x));

        
    }

    
}
