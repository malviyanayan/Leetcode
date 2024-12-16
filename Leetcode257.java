// Binary Tree Paths

class Leetcode257 {
    public static void main(String[] args) {
        // board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    }    

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visits = new boolean[rows][cols];
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(board, i, j, 0, word, visits)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean helper(char[][] board, int i, int j, int x, String word, boolean[][] visits) {

        if (x == word.length()) return true;
    
        //
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (visits[i][j] || board[i][j] != word.charAt(x)) return false;
    
        
        visits[i][j] = true;
    
        
        boolean found = helper(board, i, j - 1, x + 1, word, visits) || 
                        helper(board, i, j + 1, x + 1, word, visits) || 
                        helper(board, i - 1, j, x + 1, word, visits) || 
                        helper(board, i + 1, j, x + 1, word, visits);   
    
        
        visits[i][j] = false;
    
        return found;
    }
    
}
