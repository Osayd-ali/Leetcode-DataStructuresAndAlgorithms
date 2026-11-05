//Input: Given an integer array nums and a target
// return the indices of two different numbers within the array that sum up to the target
// We will use an outer loop to track the first element of our two sum pair
// then through the inner loop, we visit all the remaining elements coming after the outer loop's selected element and check if the current inner loop element and current outer loop element adds up to the target, if they do then we return their indices. 
// This way we are exploring combinations of all possible elements within the array 
// The core pattern here is nested loop, to make element pairs 
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
        // Slightly optimal approach, using convergent two pointer approach
        // Since we need to maintain the order of original indexes associated with their elements, we will store both in a 2 dimensional array and sort it and then perform two pointers approach to look for our element pair 
        // int[][] arr = new int[nums.length][2];
        // // Now fill in the 2 d array 
        // for(int i=0; i<nums.length; i++){
        //     arr[i][0] = nums[i];
        //     arr[i][1] = i;
        // }
        // Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        // // Now apply convergent two pointer approach 
        // // left pointer will look for the first element in our pair 
        // // right pointer will look for the second element in our pair
        // // once we have found the target, return the min index first from the pair, then the max
        // int left=0;
        // int right=arr.length-1;
        // while(left<right){
        //     int sum = arr[left][0] + arr[right][0];
        //     if(sum == target){
        //         return new int[]{Math.min(arr[left][1], arr[right][1]), 
        //                          Math.max(arr[left][1], arr[right][1])};
        //     } else if(sum < target){
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        // return new int[]{-1,-1};
        // Most optimal approach: 
        // Use a hashmap two pass solution 
        // We will create a hashmap with elements as key, and their associated index as value. 
        // then we will loop through the hashmap, and for each current index
        // we compute the complement and check if the complement exists in the map
        // if it does then we return the current index, and then the complement's index
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        //Now loop through our map using the array indices
        for(int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && map.get(diff) != i){
                return new int[]{i, map.get(diff)};
            }
        }
        return new int[]{-1,-1};
    }
}
