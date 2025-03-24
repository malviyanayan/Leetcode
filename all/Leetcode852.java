// 852. Peak Index in a Mountain Array

class Leetcode852{
    public static void main(String[] args){

    }

    static int peakIndexInMountainArray(int[] arr) {
        int peak = 0;
        int low = 0;
        int high = arr.length-1;
        int mid ;
        while(low<=high){
            mid = (low + high)/2;
            if(arr[mid]>arr[mid+1]){
                if(arr[mid]>arr[mid-1]){
                    peak = mid;
                    break;
                }else{
                    high = mid;
                }
            }else{
                low = mid;
            }
        }
        return peak;
    }
}