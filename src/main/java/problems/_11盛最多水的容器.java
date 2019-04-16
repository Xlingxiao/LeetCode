package problems;

/**
 * @Author: LX
 * @Date: 2019/4/8 22:00
 * @Version: 1.0
 */
public class _11盛最多水的容器 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        while (true) {
            int tmp = Math.min(height[left],height[right]) * (right - left);
            sum = tmp > sum ? tmp : sum;
            if (height[left] < height[right]) left++;
            else right--;
            if (left >= right) break;
        }
        return sum;
    }
}
