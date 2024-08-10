package blind75;

public class MaxProfitStock {
//    Input: prices = [7,1,5,3,6,4]

    public int maxProfit2Pointer(int[] prices) {
        int left = 0, right = 1;

        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
                right++;
            } else {
                if (maxProfit < prices[right] - prices[left]) {
                    maxProfit =  prices[right] - prices[left];
                }

                right++;
            }
        }

        return  maxProfit;
    }

    public int maxProfit(int[] prices) {
        int minStock = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i : prices) {
            if(i < minStock) {
                minStock = i;
            } else {
                if(i - minStock > maxProfit) {
                    maxProfit = i - minStock;
                }
            }
        }

        return maxProfit;
    }
}
