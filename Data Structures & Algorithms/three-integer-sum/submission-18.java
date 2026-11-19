// Input: Given an input array of integers nums, return a list of all triplet lists [nums[i], nums[j], nums[k]] where the sum of each triplet is = 0. Basically return all triplets that sum upto 0. i,j and k indices must be distinct. 
// The output should not contain duplicate triplets
// As in, {1,0,-1} and {-1,1,0} and {1,-1,0} these can be considered as duplicates. 
// Another duplicate can be, if we have multiple duplicate elements in the input array
// then there might be multiple triplets that can be formed of the same triplet
// like, {-1,0,1} and {-1,0,1} can be formed in theory two times, if we had multiple 0s and 1s in the input array.
// How do we avoid the problem of considering duplicate triplets?
// To avoid forming same triplet duplicates, we will store our triplets in a Hashset, so that same triplets can be ignored. 
// To avoid different order triplet duplicates, we will start building triplets only after the input array is sorted. this way we would not run into the problem of catching different order triplet duplicates like {1,0,-1} and {-1,1,0}. this will be totally avoided if the input array is sorted. 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Algorithm for brute force would be a nested loop approach
        // the outer most loop will select one element, then the 2 inner loops will be used to explore the remaining 2 elements of our triplet, then in the inner most loop we check if the triplet sum is equal to 0 and then add that triplet into our hashset. 
        // Set<List<Integer>> result = new HashSet<>();

        // Arrays.sort(nums);

        // for(int i=0; i<nums.length; i++){
        //     for(int j=i+1; j<nums.length; j++){
        //         for(int k=j+1; k<nums.length; k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 result.add(Arrays.asList(nums[i], nums[j], nums[k]));
        //             }
        //         }
        //     }
        // }
        
        // return new ArrayList<>(result);
        // The running time for the above approach is O(n^3).
        // Since we are sorting the input array to avoid different order duplicate triplets, 
        // We have to opportunity to apply the convergent two pointer approach in order to explore the second and third element of our triplet
        // So the algorithm goes this way, we select the first element of our triplet through a for loop, and then once that is select we begin our convergent two pointer approach to explore for the second and third element of our triplet, again, storing triplets in a hashset to avoid same order triplet duplicates. 
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            //edge case: if the first element of our sorted input array is positive, then we can never find a triplet that would equate to 0, so break the loop here itself
            if(nums[0] > 0){
                return new ArrayList<>();
            }
            //if the current element is equal to the element coming before it, then skip this element because we would just be creating another same order duplicate triplet. also i>0
            if(i>0 && nums[i] == nums[i-1]){
                continue; //skip this iteration and continue with next iteration
            }
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
