//Input: Given a sorted array of distinct values, which is rotated between 1 to n times
// and a target, return the index of the target array 
// Approach: the resultant array will consist of two sorted arrays which are in ascending order
// We need to find the pivot element, basically the largest element in the array just before the rotated version starts
// then we run binary search on the first array consisting of elements up until pivot,
// if target isn't found, we run binary search again on the right hand side sorted array from pivot+1 till end
class Solution {
    public int search(int[] nums, int target) {

        //First we will write the algorithm to find the pivot point of the rotated sorted array
        // we do binary search to find the pivot
        // the core condition is, if mid element is greater than the next element, then mid element will be our pivot for sure as long as mid index stays within the array and is less than the last element index so we dont go array out of bounds
        // if nums[mid] >= nums[start], this means we are on the left hand side of rotated array, and pivot will exist on the right search space
        // else nums[mid] < nums[start], this means we are on the right hand side of rotated array, and pivot will exist on the left search space, as this current sub array consists of all elements smaller than lhs. 
        int start = 0;
        int end = nums.length - 1;
        int pivot = 0;

        while(start<=end){
            int mid = start + (end - start)/2;
            if(mid < nums.length - 1 && nums[mid] > nums[mid+1]){
                pivot = mid;
                break;
            }
            //Conditions for choosing the search space for pivot searching
            if(nums[mid] >= nums[start]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int result = binarySearch(nums, target, 0, pivot);

        if(result == -1){
            return binarySearch(nums, target, pivot+1, nums.length - 1);
        }

        return result;
    }
    static int binarySearch(int[] nums, int target, int start, int end){
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
