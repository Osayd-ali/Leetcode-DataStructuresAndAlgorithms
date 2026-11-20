// Input: Integer array prices where the index i represents the day and the vlaue at each index i prices[i] represents the value of neet coin on ith day
// Output: Choose a single day to buy a neet coin, and choose a day to sell it
// so a buy reference which will point to the day the coin should be bought
// A sell reference which will poin to the day the coin should be sold 
// In theory, to make a profit the value at sell reference must be greater than the value at buy reference. 
// Return the maximum profit that can be made
// so a global max reference which will store the max profit
// we will utilise a nested loop approach
// where outer loop is supposed to track the index at which neet coin will be bought, so basically buy index
// Through the inner loop,  we visit all the remaining elements coming after the outer loop's selected index and check if the current element is greater than the buy index element and calculate profit for that current element and store it in our global max profit reference. Profit can only be computed, if inner loop's sell index value is greater than outer loop's buy index value
// So outer loop -> finding buy index
// inner loop -> finding sell index
class Solution {
    public int maxProfit(int[] prices) {

        // int maxProfit = 0;

        // for(int i=0; i<prices.length; i++){
        //     int buy = i;
        //     for(int j = i+1; j<prices.length; j++){
        //         int sell = j;
        //         if(prices[sell] > prices[buy]){
        //             maxProfit = Math.max(maxProfit, (prices[sell] - prices[buy]));
        //         }
        //     }
        // }
        // return maxProfit;
        // Slow approach - takes in O(n^2) time
        // We can use a parallel two pointer approach where left index will be used to find out our buy index
        // right index will be used to find our sell index
        // we will move our right index and keep exploring values greater than left index and calculate the profit for it. if right index value is less than left index value, then profit cannot be made, and we increment our left index to come towards right index. and continue to move our right index forward to look for more greater value of neet coin
        int left=0; int right=1;
        int maxProfit = 0;

        while(right < prices.length){
            if(prices[right] > prices[left]){
                maxProfit = Math.max(maxProfit, (prices[right] - prices[left]));
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
