//Input: given an integer array prices, where each element at index i represents the price of a neet coin at the ith day. We must choose a single day to buy the coin, and a single day in the future to sell the coin.
// Return the max profit that you can achieve 
// {10,1,5,6,7,1}
// buy reference will be used to track the day to buy the coin
// sell reference will be used to track the day to sell the coin
// we need to return the max profit that can be made when buying and selling the coin
// profit can only be made, when the price at selling day is greater than the price at buying day
// so for all the instances, where selling day price is greater than buying the price, we will calculate the profit by doing sell[i] - buy[i]. then we will get the max profit that can be made. 
// In the case where no profit can be made, simply return 0. 
// Algorithm: Brute force O(n^2)
// outer loop will be used to look for the buying day
// through the inner loop, we visit the day's coming after the buying day and explore each day to sell the coin
// if the price at selling day is greater than buying day, then we calculate the profit, for every profit that's been calculated we compare it with the earlier profit and choose which ever is greater and store it in our max profit. this way once we complete our array traversal we will already have our max profit. 
class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        for(int buy=0; buy<prices.length; buy++){
            for(int sell=buy+1; sell<prices.length; sell++){
                if(prices[sell] > prices[buy]){
                    int profit = prices[sell] - prices[buy];
                    maxP = Math.max(maxP, profit);
                }
            }
        }
        return maxP;
    }
}
