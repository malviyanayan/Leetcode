

class Leetcode74{

    static boolean searchMatrix(int[][] matrix, int target) {
        
        int i=0,j=matrix.length-1,mid=(i+j)/2;

        while(i <= j){
            mid = (i+j)/2;
            if(matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target){
                break;
            }else if(target <= matrix[mid][0]){
                j = mid - 1;
            }else {
                i = mid + 1;
            }
        }

        int[] targetArr = matrix[mid];
        i=0;
        j=targetArr.length - 1;

        while (i<=j) {
            mid = (i+j)/2;
            if(targetArr[mid] == target){
                return true;
            }else if(target < targetArr[mid]){
                j = mid - 1;
            }else i = mid + 1;
        }

        return false;
    }


    public static void main(String[] args) {
        // int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        // int target = 13;
        // int target = 3;
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 10;
        System.out.println(searchMatrix(matrix, target));
    }
}