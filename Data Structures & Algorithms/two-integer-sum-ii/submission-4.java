//Input: Given a sorted input array numbers 
// and as target, return the indices of two numbers that adds up to the target
// We can use a convergent two pointer approach since the array is sorted
// left pointer will be used to look for the first element in our element pair
// right pointer will be used to look for the second element in our element pair
// in each iteration of our while loop we add the elements pointed by the left and right pointers and check if they add up to the target, if they do, then return the indices
// if they dont, then if sum < target, increment left pointer since we need to make our sum bigger to go towards the target, if sum > target, then decrement right pointer since we need to make our sum smaller to go towards the target
class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int left = 0;
       int right = numbers.length - 1;
       while(left < right){
        int sum = numbers[left] + numbers[right];
        if(sum == target){
            return new int[]{left+1, right+1};
        } else if(sum < target){
            left++;
        } else{
            right--;
        }
       }
       return new int[]{-1,-1};
    }
}
