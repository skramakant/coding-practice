package liked100;


//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//Total profit is 4 + 3 = 7.
public class BestTimeToBuySell2 {

    // 2 pointer
    public int maxProfit(int[] prices) {
        int left =0, right =1;
        int totalProfit = 0;
        while (right < prices.length) {

            if(prices[right] > prices[right-1]) { // hack
                // continue
                right++;
            } else {

                int profit = prices[right-1] - prices[left];
                left = right;
                if(profit < 0) {
                    profit = 0;
                }
                totalProfit = totalProfit + profit;
                //System.out.println(totalProfit);
                right++;
            }
        }

        // if its increating array so need to handle this case
        totalProfit = totalProfit + (prices[right-1] - prices[left]);

        return totalProfit;
    }

    public int maxProfitLeetCode(int[] prices) {
        int buy, sell;
        int i =0, N = prices.length;

        int totalProfit = 0;

        while (i < N) {
            while(i+1 < N && prices[i+1] < prices[i]) {
                i++;
            }

            buy = prices[i];

            while(i+1<N && prices[i+1] > prices[i]) {
                i++;
            }

            sell = prices[i];

            totalProfit = totalProfit + (sell - buy);

            i++;
        }

        return totalProfit;
    }
}
