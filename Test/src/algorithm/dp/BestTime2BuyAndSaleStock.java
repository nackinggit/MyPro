package algorithm.dp;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author Nacking
 * 
 */
public class BestTime2BuyAndSaleStock {
	public int maxProfit(int[] prices) {
		int min, profile = 0;
		int buyDays = 0, saleDyas = 0;
		if (prices.length == 0)
			return 0;
		min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i]) {
				buyDays = i;
			}
			min = Math.min(prices[i], min);

			if (profile < prices[i] - min) {
				saleDyas = i;
			}
			profile = Math.max(prices[i] - min, profile);
		}

		System.out.println(buyDays + 1);
		System.out.println(saleDyas + 1);
		return profile;
	}

	public static void main(String[] args) {
		BestTime2BuyAndSaleStock b = new BestTime2BuyAndSaleStock();
		int[] p = { 2, 1, 3, 4, 5 };
		System.out.println(b.maxProfit(p));
	}

}
