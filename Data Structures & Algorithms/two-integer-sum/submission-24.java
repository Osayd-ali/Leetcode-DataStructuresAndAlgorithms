// Input: Given an array of integers nums and a target, return the indices of a pair of elements that adds upto the target. There exists exactly one pair within the array that adds up to the target, the pair cannot have the element at the same index twice. 
// Brute force approach: Use a nested loop approach
// The outer loop will be used to track the first element of our pair
// through the inner loop, we visit all the remaining elements coming after the outer loop's selected element, and look for the second element of the pair that adds up to the target
// Return the answer with the smaller index first. 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{-1,-1};
        // Time compexity for the above solution? would be O(n^2) since we have a nested loop
        // Slightly optimal approach
        // We can use a convergent two pointer approach and reduce the running time complexity from O(n^2) to O(n logn) + O(n). O(n) for searching the pair, and O(n logn) for sorting.
        // We know that convergent two pointer approach is best used when the array is sorted
        // But we cannot direclty sort the input array as we need to maintain the order of indexes corresponding to each element. What we will do is, create a new 2 d array with the first column taking in the elements, and the second column taking in the original index associated with the element, then we sort this array and perform our two pointer approach. 
        // left pointer will look for the first element of our pair, right pointer will look for the second element of our pair, if the sum adds up we return the min index first and then the larger index. if it doesnt add up, we check if sum < target, then increment left pointer as we need to make the sum larger to go near the target, if sum > target, we decrement right pointer as we need to make sum smaller to go near the target. 
        // int[][] arr = new int[nums.length][2];
        // for(int i=0; i<nums.length; i++){
        //     arr[i][0] = nums[i];
        //     arr[i][1] = i;
        // }
        // // Now sort our 2 dimensional array. 
        // // sort it on the basis of the first column values
        // Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        // // Now apply our convergent two pointer approach 
        // int left = 0;
        // int right = arr.length-1;
        // while(left < right){
        //     int sum = arr[left][0] + arr[right][0];
        //     if(sum == target){
        //         return new int[]{Math.min(arr[left][1], arr[right][1]), 
        //                         Math.max(arr[left][1], arr[right][1])};
        //     }
        //     else if(sum < target){
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        // return new int[0];
        // The most optimal approach would be to write a Hashmap two pass solution
        // We are maintaining a hashmap of the input arrays elements and their associated indexes
        // Once we have built that map, now we search for our pair, this is hashmap two pass solution
        // how do we search for two elements within the same for loop without the need of nested loops?
        // we start traversing our original array, and for each element of the array visited, we compute the complement of the current element and check if that complement exists in the map or not, if it does, and its not on the same index as the current selected element, then we return our pair
        Map<Integer, Integer> map = new HashMap<>();
        // Now start filling in our hashmap
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        // Once our map is created, start the search for our pair 
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) != i){
                return new int[]{i, map.get(diff)};
            }
        }
        return new int[]{-1,-1};
    }
}
