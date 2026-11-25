//Input: Given an integer array nums, and a target
// Find the indices of a pair of numbers, that sum up to the target
// i and j cant be same, dont include the element at same position twice
// Brute force approach
// Nested loop, outer loop looks for the first element and through the inner loop we visit each element coming after the outer loop's selected element to look for the second element of the pair and check if the pair sum matches the target O(n^2)
// 
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
        //Slightly Optimized approach, use a convergent two pointer approach
        // Since we need to maintain the order of indices associated with each element
        // We cannot just sort the original array, so create a 2 d array where 0th column represents the element of the original array and 1st column represents the index associated. 
        // then sort this 2 d array
        // then apply convergent two pointer approach, where left reference will look for the first element of the pair, and right will look for the second
        // if sum is equal to target, then return the indices, if sum < target, increment left reference and if sum > target decrement right pointer
        // int[][] arr = new int[nums.length][2];
        // // fill in our 2d array
        // for(int i=0; i<nums.length; i++){
        //     arr[i][0] = nums[i];
        //     arr[i][1] = i;
        // }
        // //Sort the array
        // Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        // // Now start our convergent two pointer approach
        // int left = 0;
        // int right = arr.length - 1;

        // while(left < right){
        //     int sum = arr[left][0] + arr[right][0];
        //     if(sum == target){
        //         return new int[]{Math.min(arr[left][1], arr[right][1]), 
        //                         Math.max(arr[left][1], arr[right][1])};
        //     } else if(sum < target){
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        // return new int[]{-1,-1};
        // Use a hashmap two pass solution
        // where in, the key represents the element and value represents its associated index
        // since this provide O(1) lookup, our overall running time will be O(n) which is just filling the map
        // We just look for the complement of our pair if it exists in the map or not
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        //For each element of our original array, check if its complement exists in the map or not
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) != i){
                return new int[]{i, map.get(diff)};
            }
        }
        return new int[]{-1,-1};
    }
}
