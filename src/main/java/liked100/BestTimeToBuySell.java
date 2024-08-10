package liked100;

//Input: prices = [7,1,5,3,6,4]
//Output: 5
public class BestTimeToBuySell {
    public int maxProfit(int[] prices) {
        int left = 0, right =1;

        int maxProfit = Integer.MIN_VALUE;

        while (right < prices.length) {
            if(prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                if(maxProfit < profit) {
                    maxProfit = profit;
                }
            } else {
                left = right;
            }

            right++;
        }

        return maxProfit == Integer.MIN_VALUE? 0 : maxProfit;
    }
}
