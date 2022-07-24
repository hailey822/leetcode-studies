package dynamicProgramming;

/**
 * 
 * @author hyeleekim
 * 
 * Max profit : buy on lowest price, sell on highest price
 * Buy on single day
 * Can sell and buy on the same day
 * 
 */
public class Q_0122_Best_Time_To_Buy_And_Sell_Stock_II {
	public int maxProfit(int[] prices) {
		// Handle edge case
		if(prices.length < 2) return 0;
		// Iterate
		int profit = 0;
		for(int i=1; i<prices.length; i++) {
			if(prices[i] - prices[i-1] > 0) {
				profit += prices[i] - prices[i-1];
			}
		}
        return profit;
    }
}
