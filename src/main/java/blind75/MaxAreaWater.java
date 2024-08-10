package blind75;

public class MaxAreaWater {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int i=0, j= height.length -1;

//        1,2,3,4,

        while (i<j) {
            int minHeight = Math.min(height[i], height[j]);
            int area = minHeight * (j - i);

            if(area > maxArea) {
                 maxArea = area;
            }

            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
