import java.util.Arrays;

class Leetcode240 {
    static boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0;i<matrix.length;i++){
            if(-1 < Arrays.binarySearch(matrix[i],target))return true;
        }

        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        searchMatrix(matrix, 5);
    }
}
