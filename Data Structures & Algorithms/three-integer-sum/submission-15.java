// Input: An integer array nums
// Return a list of lists containing triplets where each triplet's sum equals to 0
// Output should not contain any duplicate triplets
// like {-1,0,1} and {1,-1,0} and {0,1,-1} represent the same triplet so avoid this
// to avoid forming duplicate triplets, we can first sort the array 
// When the array is sorted, then its easier for us to identify if the inner loop's selected element is equal to the outer loop's selected element, its easier to disregard the first and second elements duplicate counterpars if the array is sorted
// we will also store the triplets in a set, to avoid duplicate triplets
// use a nested loop approach
// Outer most loop will select the first element
// first inner loop will look for the second element
// inner most loop will look for the third element in the triplet
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Set<List<Integer>> resultSet = new HashSet<>();
        // Arrays.sort(nums);

        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         for(int k=j+1; k<nums.length; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 resultSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
        //             }
        //         }
        //     }
        // }

        // return new ArrayList<>(resultSet);
        // too slow, taking O(n^3) for runtime
        // Optimized solution would be to opt for a convergent two pointer approach
        // since we are sorting the array, we have an opportunity to use convergent two pointer approach
        // where the left index will point to the element coming after i
        // right index will point to the last index
        // left index will be used to find the second element of our triplet
        // right index will be used to find the third element of our triplet
        // We will sort the array and store the list of triplets in a hashset to avoid duplicate triplets
        // we will also have some edge cases where if the very first element in the array is positve then there is no point of continuing our algorithm as we can never find a sum equal to 0
        // Also when choosing the first element of our triplet, if the element previous to i is equal to i, then also we avoid running the algorithm, since we are on the pathway to create the same triplet
        // whats the criteria for changing position of our two pointers
        // if the total sum for the triplet is greater than 0, then we decrement our right pointer
        // if total sum for the triplet is less than 0, then we increment our left pointer
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            // checking if first element is positive
            if(nums[i] > 0){
                break;
            }
            // checking if the first element is equal to its previous element
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            // Now apply the convergent two pointer approach to find second and third element
            int left = i+1;
            int right = nums.length-1;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // also while for next triplet
                    // as long as left is less than right, and the element at left index is equal to left - 1, this means that we have found our second element of the triplet to be duplicate
                } else if (sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
