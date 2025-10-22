class Leetcode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] visited = new boolean[image.length][image[0].length];
        fill(image, sr, sc, color, image[sr][sc], visited);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int color, int next, boolean[][] visited) {
        if (sr < 0 || sc < 0)
            return;
        if (sr >= image.length || sc >= image[0].length)
            return;

        if (visited[sr][sc])
            return;

        if (image[sr][sc] == next) {
            visited[sr][sc] = true;
            image[sr][sc] = color;

            fill(image, sr - 1, sc, color, next, visited);
            fill(image, sr + 1, sc, color, next, visited);
            fill(image, sr, sc + 1, color, next, visited);
            fill(image, sr, sc - 1, color, next, visited);
        }

    }

    public static void main(String[] args) {

    }
}
