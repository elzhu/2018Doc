package ab.Sep;

public class hilbertCurve {

    public static int hilbertCurve(int x, int y, int iter) {
        if (iter == 0) {
            return 1;
        }
        int len = 1 << (iter - 1);
        System.out.println("----------len : " + len);
        int num = 1 << (2 * iter - 1);
        System.out.println("----------num : " + num);
        if (x >= len && y >= len){
            return 2 * num + hilbertCurve(x - len, y - len, iter - 1);
        } else if (x < len && y >= len) {
            return num + hilbertCurve(x, y - len, iter - 1);
        } else if (x < len && y < len) {
            return hilbertCurve(y, x, iter - 1);
        } else {
            return 3 * num + hilbertCurve(len - y - 1, 2 * len  - x  - 1, iter - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("------hilbertCurve : " + hilbertCurve(4, 4, 2));
    }
}
