package ab.Sep;

public class waterDrop {

    public static void pourWater(int[] heights, int water, int location) {
        int n = heights.length;
        int[] waters = new int[n];
        int purLocation;
        while (water > 0) {
            int left = location - 1;
            while (left >= 0) {
                if (heights[left] + waters[left] > heights[left + 1] + waters[left + 1]) {
                    break;
                }
                // Try to find the left position for water
                left--;
            }

            if (heights[left + 1] + waters[left + 1] < heights[location] + waters[location]) {
                purLocation = left + 1;
                waters[purLocation]++;
                water--;
                continue;
            }

            int right = location + 1;
            while (right < heights.length) {
                if (heights[right] + waters[right] > heights[right - 1] + waters[right - 1]) {
                    break;
                }
                right++;
            }

            if (heights[right - 1] + waters[right - 1] < heights[location] + waters[location]) {
                purLocation = right -1;
                waters[purLocation]++;
                water--;
                continue;
            }

            purLocation = location;
            waters[purLocation]++;
            water--;

        }
        print(heights, waters);
    }
    public static void print(int[] heights, int[] waters) {
        int n = heights.length;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, heights[i] + waters[i]);
        }

        for (int height = maxHeight; height > 0; height--) {
            for (int i = 0; i < n; i++) {
                if (height <= heights[i]) {
                    System.out.print("+");
                } else if (height > heights[i]  && height <= heights[i] + waters[i]) {
                    System.out.print("W");
                } else {
                    System.out.print(" ");
                }
            }
           System.out.println();
        }
      System.out.println();
    }

    public static void main (String[] args) {
        int[] heights = {5,4,2,1,2,3,2,1,0,1,2,4};
        int[] waters = {0,0,1,2,1,0,0,1,2,1,0,0};
        pourWater(heights, 8, 7);
    }
}
