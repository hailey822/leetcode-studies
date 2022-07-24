package dynamicProgramming;
/**
 * 
 * @author hyeleekim
 * 
 * Max profit : buy on lowest price, sell on highest price
 * (Buy on single day, diff day in the future to sell)
 * 
 * 1. Handle edge case : there needs to be at least 2 days
 * 2. Init values int buy, ma = -1
 * 3. Loop through and save index on day to buy and sell 
 * 		(1) buy = Min val from left to buy
 * 		(2) sell = Max val from right to sell
 * 4. If buy or sell is -1, return 0
 * 5. Otherwise, return prices[sell]-prices[buy]
 * 
 */

public class Q_0121_Best_Time_To_Buy_And_Sell_Stock {
	public int maxProfit(int[] prices) {
		// Handle edge case
		if(prices.length < 2) return 0;
		
		// Init values 
		int buy = 0;
		int max = 0;
		
		// Loop through prieces
		for(int i=1; i<prices.length; i++) {
			if(prices[i] < prices[buy]) buy = i;
			else {
				max = Math.max(max,  prices[i] - prices[buy]);
			}
		}
        return max;
    }
}
