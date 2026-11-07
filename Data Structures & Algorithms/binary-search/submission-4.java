// Input: Given an integer array nums which is sorted in non decreasing order
// and a target, find the index of the target if it exists in the array
// If we do linear search, we would be visiting each element of the array, and then check if target exists, but we would be traversing through the entire array which takes at most n iterations
// But if we do binary search for the target, we can reduce our search time by literally half
// we do this by, repeatedly dividing the array into two halves, and then looking for target in the relevant search space
// we compute the mid point, and then compare target with the mid value to decide on which half to search in the coming iteration. 
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                return mid;
            } else if(target < nums[mid]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
