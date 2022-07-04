import java.util.HashMap;
import java.util.Map;

/**
 * @author yw
 * @since 2022/02/20
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int s = solution.maxProfit(new int[]{2,4,1});
        System.out.println(s);

    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int min = Integer.MAX_VALUE;
        int max = -1;
        int minIndex = 0;
        int res = -1;
        for (int i = 0; i < length; i++) {
            if (min > prices[i]) {
                min = prices[i];
                minIndex = i;
                max = -1;
            }
            if (i > minIndex) {
                if (max < prices[i]) {
                    max = prices[i];
                    res = Math.max(res, max - min);
                }
            }
        }
        if (res != -1) return res;
        if (max == -1) return 0;
        return max - min;
    }
}
