class NextGreatestElement {

    static int[] nextGreater(int[] arr){
        int[] res = new int[arr.length];

        int great = -1;

        for(int i = arr.length - 1; i >= 0; i--){
            res[i] = great;
            if(great < arr[i])great = arr[i];
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {12,8,41,37,2,49,16,28,21};
        System.out.print("My Array is : [");
        for(int next : arr){
            System.out.print(next + ", ");
        }

        int [] temp = nextGreater(arr);

        System.out.print("]\nMy Next Greater Element Array is : [");
        for(int next : temp){
            System.out.print(next + ", ");
        }

        System.out.println("]");
    }
}