//Input: an array of distinct integers, which is sorted in ascending order, and an integer target
// Output: return the target's index if it exists in nums otherwise return -1
// Algorithm:
// To do this in O(log n) time, we must search for target in the array using binary search
// Binary search says that, instead of visitng each element in the array and traversing the whole array
// We must keep dividing the array into two equal halves and look for the target element in the relevant search space
// we divide the array by calculating the mid point of the array, and we choose the next relevant search space by comparing the target with the mid value
// if target == mid, then return mid index
// if target less than mid, then look for target in the left search space, reduce our next search space by pointing end reference to mid - 1 index
// if target is greater than mid, then look for target in the right search space, reduce our next search space by pointing start reference to mid + 1 index
class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while(start<=end){
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
