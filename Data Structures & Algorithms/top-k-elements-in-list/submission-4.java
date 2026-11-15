//Input: integer array nums, and an integer k, return the k most frequent elements in the array
// returning the k most frequently occurring elements
// question mentions frequency count so, we have an opportunity to build a frequency map
// once we've built the frequency map of each element in the array and the number of times it occurs, we will have to find a way of sorting our map which is difficult because hashmap collection is unordered and cannot be sorted
// build an arraylist representation of all our map entries and sort this array list in decreasing order
// then create an array of size k and fill it with the top k elements from our array list
// return this result array
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // build a frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // Now create an array list representation of all our map entries 
        List<Map.Entry<Integer, Integer>> lst = new ArrayList<>(map.entrySet());
        // Now sort it in decreasing order
        lst.sort((a,b) -> b.getValue() - a.getValue());
        // create a result array
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = lst.get(i).getKey();
        }

        return result;
    }
}
