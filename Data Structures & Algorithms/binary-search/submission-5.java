//Input: Given an integer array nums and a target
// Find the index of the target, if it exists in the array. 
// Do it in O(log n) time
// Typically we would do a linear search, that is traverse the entire array and visit each element within the array and check if its equal to the target. This would happen in O(n) time. 
// But, we can reduce the time by half. instead of search all the elements of the array 
// we divide the array into two equal halves, and look for target only in the relevant half
// the criteria to select for the correct search space would be the comparison of mid value with the target value. If target is less than mid, we look for target in left search space
// if target greater than mid, we look for target in right search space
// if target equal to mid, then return mid index
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
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
