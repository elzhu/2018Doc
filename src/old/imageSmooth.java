package old;

public class imageSmooth {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
    public int[][] imageSmoother(int[][] M) {
        int[][] smooth = new int[M.length][M[0].length];
        for(int i=0; i<M.length; i++){
            for(int j=0; j<M[0].length; j++){
                int sum=M[i][j];
                int count=1;
                for(int[] direction : directions){
                    if(isValid(M, i+direction[0], j+direction[1])){
                        sum += M[i+direction[0]][j+direction[1]];
                        count++;
                    }
                }
                smooth[i][j]=sum/count;
            }
        }
        return smooth;
    }
    public boolean isValid(int[][] M, int row, int col){
        return !(row<0 || row>=M.length || col<0 || col>=M[0].length);
    }

    public int[][] imageSmoother2(int[][] M) {
        if (M == null) return null;
        int rows = M.length;
        // if (rows == 0) return new int[0][];
        int cols = M[0].length;
        int result[][] = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;
                int sum = 0;
                for (int incR : new int[]{-1, 0, 1}) {
                    for (int incC : new int[]{-1, 0, 1}) {
                        if (isValid2(row + incR, col + incC, rows, cols)) {
                            count++;
                            sum += M[row + incR][col + incC];
                        }
                    }
                }
                result[row][col] = sum / count;
            }
        }
        return result;
    }

    private boolean isValid2(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
