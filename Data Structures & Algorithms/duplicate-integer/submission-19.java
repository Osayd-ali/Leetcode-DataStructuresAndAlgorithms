//Input: given an integer array nums, return true if the array contains duplicate elements
// brute force approach, use a nested loop approach
// the outer loop will be used to track the original element and the inner loop will be used to verify if duplicate of the outer loop's selected element exists, if it does, then return true
// so start outer loop from the first element, through the inner loop, we visit each element coming after the outer loop's selected element and compare the equality of both selected elements
class Solution {
    public boolean hasDuplicate(int[] nums) {
       for(int i=0; i<nums.length; i++){
        for(int j=i+1; j<nums.length; j++){
            if(nums[i] == nums[j]){
                return true;
            }
        }
       }
       return false; 
    }
}