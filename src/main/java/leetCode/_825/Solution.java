package leetCode._825;

import java.util.Arrays;

/**
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 *
 * 示例 1：
 *
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * 示例 2：
 *
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * 示例 3：
 *
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 *
 * 提示：
 *
 * n == ages.length
 * 1 <= n <= 2 * 104
 * 1 <= ages[i] <= 120
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    /**
     * 建立一个大小为120 的数组 将每个年龄的消息总数存进去
     * 1. 遍历
     * 2. 从数组中拿到数据判断是否已经有数据
     *
     * @param ages 年龄集合
     * @return 总消息数量
     */
    public int numFriendRequests(int[] ages) {
        int sum = 0;
        if (ages == null || ages.length < 2) {
            return sum;
        }
        int[] counts = new int[121];
        Arrays.fill(counts, -1);

        for (int i = 0; i < ages.length; i++) {
            int currentAge = ages[i];
            if (counts[currentAge] >= 0) {
                sum += counts[currentAge];
                continue;
            }
            int swap = 0;
            for (int j = 0; j < ages.length; j++) {
                if (j == i) {
                    continue;
                }
                if (sendMsg(currentAge, ages[j])) {
                    sum++;
                    swap++;
                }
            }
            counts[currentAge] = swap;
        }
        return sum;
    }

    private boolean sendMsg(int x, int y) {
        if (y <= (x * 0.5 + 7)) {
            return false;
        }
        // 2 3 规则这里使用2 即可
        if (y > x) {
            return false;
        }
        return true;
    }
}