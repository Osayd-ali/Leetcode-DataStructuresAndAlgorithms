// Input: integer array nums {1,3,2,4}
// Output: boolean. True if the array contains any duplicates and false if it doesnt
// Brute force approach, we will have a nested loop
// The outer loop will select one element
// Through the inner loop, we visit all the remaining elements of the array and check if the duplicate of outer loop's selected element exists. if it exists i.e. nums[i] == nums[j] then return true. duplicate is found
// If not, then increment our outer loop to go to the next element, and then compare all the remaining elements with it 
// This way, we are visiting each element and checking if a duplicate exists for that element in all the remaining elements coming after it
// At worst case, array is being traversed N * N times
class Solution {
    public boolean hasDuplicate(int[] nums) {
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] == nums[j]){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        // Optimized approach
        // We know that a hashset stores only unique values
        // Why not store all the elements of the array in a set
        // before adding the element into the set, we will check if the set already contains that element, if it does then return true as duplicate has been found
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