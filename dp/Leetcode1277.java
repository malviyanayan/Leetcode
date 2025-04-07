class Leetcode1277 {
    static int countSquares(int[][] matrix) {
        int count = 0,m = matrix.length,n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println(i + ", " + j);
                if(matrix[i][j] == 0)continue;
                if(i > 0 && j > 0){
                    matrix[i][j] += Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
                }
                count += matrix[i][j];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        // System.out.println("Matrix:");
        // for (int[] row : matrix) {
        //     for (int cell : row) {
        //     System.out.print(cell + " ");
        //     }
        //     System.out.println();
        // }

        int result = countSquares(matrix);
        System.out.println("Number of square submatrices with all ones: " + result);
    }
}
