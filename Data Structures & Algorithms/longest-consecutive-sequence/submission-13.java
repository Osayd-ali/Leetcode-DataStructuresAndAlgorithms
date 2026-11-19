//Input: given an array of integers nums, find the longest consecutice sequence that can be formed from the original array, a consecutive sequence means every element is exactly greate by 1 than the previous elemnt, the sequence doesnt have to be in consecutive or continous in the original array. so basically, we are not exaclty just trying to pick the consecutive sequence already existing in the original array, but we gotta build our longest consecutive sequence by picking elements from the original array. 
class Solution {
    public int longestConsecutive(int[] nums) {
       //The brute force approach would be, 
       // we use a nested loop approach, where in we try to build a longest consecutive sequence for every element in the original array as the starting elementing of their respective sequences
       // then once we do that, we get the max length of all these sequences built and return the max length as our result
       // so we pick one element from the original array through the outer loop, this would be the starting element for the current sequence, then through the inner loop, we visit all the elements of the array and only consider elements that's greater by 1 to add it into our longest sequence.
       // we maintain a streak variable, and then in the inner loop, whenever we come across an element exactly greater by 1 than the previously considered inner loop element, we increment our streak. 
       // then, once we no longer have any greater elements by 1 than the previously considered element we exit the loop and take in the max between current streak and previously considered max. 
    //    int maxStreak = 0;
    //    for(int i=0; i<nums.length; i++){
    //     int streak = 1; // since currently we have one element in our sequence that is the current element
    //     int current = nums[i]; // we keep updating current element for this sequence every time we find an element greater by 1. 
    //     // start building sequence for this selected element as starting of the sequence
    //     while(true){
    //         boolean found = false;
    //         for(int j=0; j<nums.length; j++){
    //         //if the next element in our seq is exactly greater than current element then increment our streak
    //             if(nums[j] == current + 1){
    //                 streak++;
    //             // then update our current variable with this element
    //                 current++; // since this element is exactly greater by 1 we could just increment old current variable to replace it with this value
    //             found = true;
    //                 break; // break this loop entirely and start searching again for next element greater by 1 from the beginning 0th index of original array
    //             }
    //         }
    //         if(!found){
    //             break;
    //         }
    //     }
    //         maxStreak = Math.max(maxStreak, streak);
    //    }
    //    return maxStreak;
    // Optimized version, we need to do this in just O(n) time
    // so at worst, just one array traversal to build our sequences 
    // since each of our sequences must only contain distinct elements increasing by 1
    // we can eliminate the need of repeatedly visiting duplicate elements when looking for the next element in our sequence by first copying the array elements into a hashset, now we will have a set consisting of only unique elements
    // Now we have to options, that is access each element from our hashset and then try to build sequences for each element of our hashset as the starting element of the sequence
    // then, as long as we are finding elements greater by 1 than the current element we keep increasing our streak
    // the other option is, instead of trying to build duplicate sequences as well, because in the previous approach we were building sequences for each element of the set as the starting element, so we would always be repeating duplicate sequences as well
    // but in this approach, we will only build a sequence if we know for sure that the current element is the starting element of the sequence. 
    // how do we identify if the current element is actually the starting element of its sequence? we can know this by checking if the set does NOT contain an element which is current - 1, if the set does not contain an element smaller by 1 than the current element then we know for sure that this current element is the starting element of the sequence
    // First initialize a hashset and fill it
    Set<Integer> set = new HashSet<>();
    int maxStreak = 0;

    for(int num: nums){
        set.add(num);
    }
    // now traverse through our array and start building sequences for each element as the starting element of the sequence
    for(int num: nums){
        //We will only be building sequences if we know for sure that this element is the starting element of its sequence, we do that by checking if num - 1 exists in the set or not
        if(!set.contains(num-1)){
            int streak = 1;
            //Now we know that the current element is indeed the starting element of the sequence
            // Now check if the set contains curr + 1
            while(set.contains(num + streak)){
                // keep incrementing our streak
                streak++;
            }
            maxStreak = Math.max(maxStreak, streak);
        }
    }
    return maxStreak;
    }
}
