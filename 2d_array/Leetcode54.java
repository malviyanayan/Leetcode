import java.util.List;
import java.util.ArrayList;

class Leetcode54{

    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        
        int sr = 0, sc = 0, er = matrix.length - 1, ec = matrix[0].length - 1;
        
        while(sr <= er && sc <= ec){
            for(int j = sc;j<=ec;j++){
                list.add(matrix[sr][j]);
            }

            for(int j = sr+1;j<=er;j++){
                if(sr==er)break;
                list.add(matrix[j][ec]);
            }

            for(int j = ec-1;j>=sc;j--){
                list.add(matrix[er][j]);
            }
            for(int j=er-1;j>=sr+1;j--){
                if(sc==ec)break;
                list.add(matrix[j][sc]);
            }

            sc++;
            sr++;
            ec--;
            er--;
        }
        
        return list;
    }

    public static void main(String[] args){
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(mat));
    }
}