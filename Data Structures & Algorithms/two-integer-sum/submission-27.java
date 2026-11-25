//Input: Given an integer array nums, and a target
// Find the indices of a pair of numbers, that sum up to the target
// i and j cant be same, dont include the element at same position twice
// Brute force approach
// Nested loop, outer loop looks for the first element and through the inner loop we visit each element coming after the outer loop's selected element to look for the second element of the pair and check if the pair sum matches the target
// 
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
