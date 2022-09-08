package com.nitron.leetcodedaily.BestTimeToBuySellStocks;

public class BestTimeToBuySellStocks {

    int max =0;
    public int calcBestPrice(int[] prices) {

        if (prices.length == 1)
            return 0;

        int result = 0;
        int min = Integer.MAX_VALUE;

        for (int i=0;i<prices.length;i++) {
            min = Math.min(prices[i], min);
            result = Math.max(prices[i]-min, result);
        }
        return result;
    }

    private int calcBestPrice(int[] prices, int n) {

         max = 0;
        for (int i = 0; i <= n; i++)
            for (int j = i + 1; j <= n; j++) {
                if (prices[j] > prices[i]) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        return max;
    }
}
