class Leetcode33{
    public static void main(String[] args){
        // int[] arr = {1,4,7,9,12,8,6};
        // int[] arr = {4,5,6,7,0,1,2};
        // int target = 0;
        // int[] arr = {4,5,6,7,0,1,2};
        // int target = 3;
        // int[] arr = {1};
        // int target = 0;
        // int[] arr = {3,1};
        // int target = 3;
        int[] arr = {6,7,1,2,3,4,5};
        int target = 6;
        
        

        System.out.println(mountain(arr) + ", ele : " + search(arr, target));
        // System.out.println(binarySearch(arr, mountain(arr), arr.length-1, target));
        // System.out.println(binarySearch(arr, 0, arr.length-1, target));
        
    }

    // static int search(int[] nums, int target){
    //     int s = 0, e = nums.length - 1;

    //     while (s <= e) {
    //         int mid = s + (e - s) / 2;

    //         // Check if mid is the target
    //         if (nums[mid] == target) return mid;

    //         // Determine if we are in the left sorted portion
    //         if (nums[s] <= nums[mid]) {
    //             if (nums[s] <= target && target < nums[mid]) {
    //                 e = mid - 1;
    //             } else {
    //                 s = mid + 1;
    //             }
    //         }
    //         // We are in the right sorted portion
    //         else {
    //             if (nums[mid] < target && target <= nums[e]) {
    //                 s = mid + 1;
    //             } else {
    //                 e = mid - 1;
    //             }
    //         }
    //     }
    //     return -1;

    // }

    static int search(int[] nums, int target) {
        if(nums.length <= 3){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target)return i;
            }
            return -1;
        }
        int mountain = mountain(nums);
        if(mountain == -1)return binarySearch(nums,0,nums.length-1, target);
        int search = -1;
        search = binarySearch(nums, 0, mountain, target);
        System.out.println(search);
        if(search == -1)search = binarySearch(nums, mountain+1, nums.length-1, target);
        return search;
    }

    static int binarySearch(int[] arr,int s,int e,int target){
        while(s<=e){
            int mid = e-(e-s)/2;
            if(arr[mid]==target)return mid;
            else if(arr[mid]>target)e = mid-1;
            else s = mid+1;
        }
        return -1;
    }   


    // 6,7,1,2,3,4,5
    static int mountain(int[] arr) {
        int s = 1, e = arr.length - 2; // Start and end just inside the bounds to avoid boundary issues
    
        // Check the boundary elements for peak conditions
        if (arr[1] < arr[0]) return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2]) return arr.length - 2;
    
        // Binary search within the array
        while (s <= e) {
            int mid = s + (e - s) / 2; // Correct formula for mid
    
            // Check if the current element is a peak
            if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) { // Move to the right half
                s = mid + 1;
            } else { // Move to the left half
                e = mid - 1;
            }
        }
    
        return -1; // If no peak is found, though in a mountain array, there should be a peak
    }
    
    
}