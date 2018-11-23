package bigf.HashMap;

import java.util.HashMap;
import java.util.Map;

public class maxPoints {
    public static int maxPoints(Point[] points) {
        int result = 0;
        if(points.length <= 0) return result;
        if(points.length <= 2) return points.length;
        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        for (int i=0;i<points.length;i++){
            map.clear();
            int overlap=0,max=0;
            for (int j=i+1;j<points.length;j++){
                int x=points[j].x-points[i].x;
                int y=points[j].y-points[i].y;
                System.out.println("-----x : " + x);
                System.out.println("-----y : " + y);

                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd=generateGCD(x,y);
                System.out.println("-----gcd : " + gcd);
                if (gcd!=0){
                    x/=gcd;
                    y/=gcd;
                }
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                }else {
                    Map<Integer,Integer> m = new HashMap<Integer,Integer>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max=Math.max(max, map.get(x).get(y));
                }
            result=Math.max(result, max+overlap+1);
        }

            return result;
    }

    private static int generateGCD(int a, int b){

        if (b==0) return a;
        else return generateGCD(b,a%b);

    }

    public static void main(String[] args) {
        Point a = new Point(1,1);
        Point b = new Point(3,2);
        Point c = new Point(5,3);
        Point d = new Point(4,1);
        Point e = new Point(2,3);
        Point f = new Point(1,4);
        Point[] points = {a, b, c,d,e,f};
        System.out.println(maxPoints(points));
    }
}
