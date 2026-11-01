class Solution {
    public int search(int[] nums, int target) {
        //Basic binary search
        // start reference points to the first element
        int start = 0;
        int end = nums.length - 1;
        // as long as start is less than or equal to end
        // keep dividing the array into two equal search spaces, and look for target in the relvant search space
        // to choose the search space, compare target to mid
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                return mid;
            } else if(target < nums[mid]){ // look for target in left search space, so reduce our search space to lhs   
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
