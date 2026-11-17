//Input: We are given an integer array nums
// we need to return an array output where each element at each index in the out consists of the product of all the elements from the original array except for the current index element
// so for each index in the result array calculate the product of all elements except the element at its own index. 
// Eg: {1, 2, 4, 6} -> {(2*4*6), (1*4*6), (1*2*6), (1*2*4)}
// The brute force solution would be: 
// Use a nested loop approach where the outer loop will be used to track the index whose product is supposed to be computed
// Through the inner loop, we visit all the elements from the original array and keep building the product for the outer loop's selected index, while building the product, if we come across element at the outer loop's selected index, then we just skip that element from our loop iteration and continue building the product from the next elements.
// We also need to have a product variable that we use to keep building our product for each index 
// this would be a local variable inside the outer for loop since we need to keep resetting our product for each newly selected index whose product is supposed to be computed. 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int[] result = new int[nums.length];
        // for(int i=0; i<nums.length; i++){
        //     int product = 1;
        //     for(int j=0; j<nums.length; j++){
        //         if(i == j){
        //             continue; 
        //         }
        //         product *= nums[j];
        //     }
        //     result[i] = product;
        // }
        // return result;
        // For a more optimal approach, what we could do use a prexif array and a suffix array
        // the prefix array would be used to compute the product of all elements coming before the selected index for that selected index.
        // edge case here would, since there is no element before the first index of the original array, the product at that index in our prefix array would be just 1. 
        // the suffix array would be used to compute the product of all elements coming after the selected index for that selected index.
        // How do we compute the prefix products for the rest of the indexes? 
        // we would just do, previous element's computed prefix product multiplied by element at the previous index of the current selected index. 
        // edge case here, since there is no element coming after the last index of the original array, the product at the last index in our suffix array would just be 1. 
        // we will start filling in our suffix array from the last second element
        // it should be, suffix product of next element multiplied by the next element for the current index
        // our result array would just be the product of both of these arrays
        // here we are reducing our time complexity from O(n^2) to 2* O(n) which would be O(n). 
        int[] prefix = new int[nums.length];
        // first index of our prefix array should default to having a prefix product of 1
        prefix[0] = 1;
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }
        int[] suffix = new int[nums.length];
        // last index of our suffix array should default to having a suffix product of 1
        suffix[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
