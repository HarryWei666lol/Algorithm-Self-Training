package easy;

public class Qn121BestTimeToBuyAndSellStock {

	// Time 78.56%, Space 5.31%
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int buyPrice = prices[0];
        int max = 0;
        
        int len = prices.length;
        for(int i = 0; i < len; i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            } else {
                int profit = prices[i] - buyPrice;
                max = profit > max ? profit : max;
            }
        }
        
        return max;
    }

}
