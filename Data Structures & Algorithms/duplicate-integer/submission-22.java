//Input: given an integer array nums, return true if the array contains duplicate elements
// brute force approach, use a nested loop approach
// the outer loop will be used to track the original element and the inner loop will be used to verify if duplicate of the outer loop's selected element exists, if it does, then return true
// so start outer loop from the first element, through the inner loop, we visit each element coming after the outer loop's selected element and compare the equality of both selected elements
class Solution {
    public boolean hasDuplicate(int[] nums) {
    //    for(int i=0; i<nums.length; i++){
    //     for(int j=i+1; j<nums.length; j++){
    //         if(nums[i] == nums[j]){
    //             return true;
    //         }
    //     }
    //    }
    //    return false; 
    // Optimal approach
    // as we need to identify if the input array contains duplicate elements
    // we could transfer all those elements into a hash set collection, as a set collection is known for only storing unique elements and discards duplicates
    // with each iteration of adding in the element from the array into the set, we check before adding if the set contains the current element, if it does then this is a duplicate so return true
        Set<Integer> set = new HashSet<>();
        for(int x: nums){
            if(set.contains(x)){
                return true;
            }
            set.add(x);
        }
        return false;
    }
}