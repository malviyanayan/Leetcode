class Leetcode59 {

    static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int sr = 0, sc = 0, er = n - 1, ec = n - 1;
        int x = 1;
        
        while(sr <= er && sc <= ec){
            for(int j = sc;j<=ec;j++){
                res[sr][j] = x++;
            }

            for(int j = sr+1;j<=er;j++){
                if(sr==er)break;
                res[j][ec] = x++;;
            }

            for(int j = ec-1;j>=sc;j--){
                res[er][j] = x++;;
            }
            for(int j=er-1;j>=sr+1;j--){
                if(sc==ec)break;
                res[j][sc] = x++;
            }

            sc++;
            sr++;
            ec--;
            er--;
        }
        

        return res;
    }

    public static void main(String[] args){

    }    
}
