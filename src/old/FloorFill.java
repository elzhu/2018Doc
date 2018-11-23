package old;

public class FloorFill {


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int newColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr - 1, sc, newColor, color);
        fill(image, sr + 1, sc, newColor, color);
        fill(image, sr, sc - 1, newColor, color);
        fill(image, sr, sc + 1, newColor, color);
    }

    public static void main(String [ ] args)
    {
        int[][] image = {{1,1,1},{1,1,0},{1,0,}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] res = floodFill(image, sr, sc, newColor);

        for(int i = 0; i<res.length; ++i)
        {
            for(int j = 0; j < res[0].length; ++j)
            {
                System.out.println("i: " + i);
                System.out.println("j: " + j);
                System.out.println("res[i][j] " + res[i][j]);
                System.out.println("----------floodFill[][]: " + i + j + " "+ res[i][j]);
            }
            //System.out.println();
        }
    }
}


