//Input: Given an integer array nums and a target
// return the indices of two different numbers within the array that sum up to the target
// We will use an outer loop to track the first element of our two sum pair
// then through the inner loop, we visit all the remaining elements coming after the outer loop's selected element and check if the current inner loop element and current outer loop element adds up to the target, if they do then we return their indices. 
// This way we are exploring combinations of all possible elements within the array 
// The core pattern here is nested loop, to make element pairs 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
