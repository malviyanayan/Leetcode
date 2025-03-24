class Leetcode167 {
    public static void main(String[] args) {
        // int[] arr = {2,7,11,15};
        // int target = 9;
        int[] arr = {2,3,4};
        int target = 6;

        int[] ans = twoSum(arr, target);
        System.out.println("ans is : " + ans[0] + ", " + ans[1]);
    }   
    
    static int[] twoSum(int[] numbers, int target) {
        int[] ans = {-1,-1};

        for(int i=0;i<numbers.length;i++){
            ans[0] = i+1;
            ans[1] = search(numbers,i+1,numbers.length-1,target-numbers[i]);
            if(ans[1] != -1){
                ans[1]++;
                break;
            }
        }

        return ans;
    }

    static int search(int[] arr,int s,int e,int target){
        if(s>e)return -1;
        int mid = e-(e-s)/2;

        if(arr[mid]==target)return mid;
        else if(arr[mid]<target) return search(arr, s+1, e, target);
        else return search(arr, 0, mid-1, target);
    }




    // This is optimized version.....hahaha
    // static int[] twoSum(int[] numbers, int target) {
    //     int[] ans = {-1,-1};
    //     int s = 0,e = numbers.length - 1;
    //     while(s<e){
    //         if(numbers[s] + numbers[e] == target){
    //             ans[0] = s+1;
    //             ans[1] = e+1;
    //             return ans;
    //         }else if(target - numbers[s] < numbers[e])e--;
    //         else s++;
    //     }
    //     return ans;
    // }
}
