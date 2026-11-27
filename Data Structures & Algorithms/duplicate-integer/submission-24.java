//Input: Given an integer array nums, return true if the array contains duplicate elements
// the brute force approach would be: 
// will implement a nested loop approach
// the outer loop will visit all the element in the array
// through the inner loop, we visit each element coming after the outer loop's selected element and see if the duplicate exists
// if it does then we return the true immediately
// if not, then we traverse the entire array twice and then return false. 
class Solution {
    public boolean hasDuplicate(int[] nums) {
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[j] == nums[i]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        // But for a more optimized approach, we can use a hash set
        // as set contains only unique elements and discards duplicates
        Set<Integer> set = new HashSet<>();

        // fill in our hashset, this happens in O(n) time
        for(int num: nums){
            // before adding check if the current element already exists 
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}