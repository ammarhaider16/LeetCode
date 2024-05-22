class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image.length == 0) return image;

        int start = image[sr][sc];
        fill(image, sr, sc, color, start);

        return image;
    }

    public void fill(int[][] image, int sr, int sc, int color, int start) {
        if (sr > image.length - 1 || sr < 0 || sc > image[0].length - 1 || sc < 0) return;
        if (image[sr][sc] != start || image[sr][sc] == color) return;

        image[sr][sc] = color;

        fill(image, sr+1, sc, color, start);
        fill(image, sr-1, sc, color, start);
        fill(image, sr, sc+1, color, start);
        fill(image, sr, sc-1, color, start);
        

    }
}