//Input: Given a sorted array nums in ascending order, which is rotated by 1-n indices. 
// Return the minimum element in the array
// In theory we could find the pivot, and then return the next element after it which is guaranteed to be the most minimum element. 
// or vice versa, that is, if any current element is less than its previous element, then the current element will be our most min element, as we are at the rotation point and no where else in the array will there be two values where one value is actually less than the previous index value as this is in ascending order
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        //Edge case: if array is not rotated and is just in ascending order, then just return the first element as that will be the most minimum
        if(nums[start] <= nums[end]){
            return nums[start];
        }
        // do binary search,
        // if nums[mid] < nums[mid - 1], then mid - 1 will be our most minimum value as this is the rotation point
        // mid - 1 will be the peak.
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            //Conditions to look for the min value
            //if our mid value is less than the end value, for this current selected portion, then we are on the
            // first sorted portion of the array, and min value will likely appear on the right search space 
            if(nums[mid] > nums[end]){
                start = mid + 1;
            } else { // if nums[mid] < nums[start], then we are on the right sorted sub array coming after pivot, this is generally consisting of all elements lesser than the first sorted array, and is in ascending order, so most minimum value will exist on the left search space in this current selected sub array, current mid might also be our most min value so include it in the next search
                end = mid;
            }
        }
        return -1;
    }
}
