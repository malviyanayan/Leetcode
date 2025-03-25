import java.util.HashSet;

class Leetcode36{


    // Little Improved
    public boolean isValidSudoku1(char[][] board) {

        // teen set banao aur unme teesre rull ke liye dekho
        HashSet<Character> set1 = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();
        HashSet<Character> set3 = new HashSet<Character>();


        for(int i=0;i<9;i++){
            if(i%3 == 0){
                set1.clear();
                set2.clear();
                set3.clear();
            }

            HashSet<Character> rows = new HashSet<>();

            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    // for rows
                    if(rows.contains(board[i][j]))return false;
                    rows.add(board[i][j]);

                    if(j<3){
                        if(set1.contains(board[i][j]))return false;
                        set1.add(board[i][j]);
                    }else if(j<6){
                        if(set2.contains(board[i][j]))return false;
                        set2.add(board[i][j]);
                    }else{
                        if(set3.contains(board[i][j]))return false;
                        set3.add(board[i][j]);
                    }
                }
            }
        }

        // column validation
        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0;j<9;j++){
                if(board[j][i] != '.' && set.contains(board[j][i]))return false;
                if(board[j][i] != '.'){
                    set.add(board[j][i]);
                }
            }
        }

        return true;
    }


    public boolean isValidSudoku(char[][] board) {

        // row validation
        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0;j<9;j++){
                if(board[i][j] != '.' && set.contains(board[i][j]))return false;
                if(board[i][j] != '.'){
                    set.add(board[i][j]);
                }
            }
        }


        // column validation
        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0;j<9;j++){
                if(board[j][i] != '.' && set.contains(board[j][i]))return false;
                if(board[j][i] != '.'){
                    set.add(board[j][i]);
                }
            }
        }

        // teen set banao aur unme teesre rull ke liye dekho
        HashSet<Character> set1 = new HashSet<Character>();
        HashSet<Character> set2 = new HashSet<Character>();
        HashSet<Character> set3 = new HashSet<Character>();

        for(int i=0;i<9;i++){
            if(i%3 == 0){
                set1.clear();
                set2.clear();
                set3.clear();
            }

            for(int j=0;j<9;j++){
                if(board[i][j] != '.'){
                    if(j<3){
                        if(set1.contains(board[i][j]))return false;
                        set1.add(board[i][j]);
                    }else if(j<6){
                        if(set2.contains(board[i][j]))return false;
                        set2.add(board[i][j]);
                    }else{
                        if(set3.contains(board[i][j]))return false;
                        set3.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        
    }
}