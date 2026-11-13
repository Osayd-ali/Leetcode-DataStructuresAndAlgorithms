//Input: An array of strings strs, i.e. array consisting of string objects
// Group all anagrams together into sublists
// Output: Return the list of sublists containing strings which are anagrams of each other
// So each sublist must contain strings which are anagrams of each other and we store these sublists into a global list and return this global list as part of our result
// So we will maintain a hashmap where the key signifies the sorted version of each string and the value associated signifies the sublist containing anagrams of the sorted string key
// The idea is;
// We first access each string from the array of strings
// Build a sorted version of each string
// then add the sorted string into the map and create an empty list associated with it to maintain room for adding the anagrams of that sorted string
// Before adding the sorted string into our map, we check if the sorted version of current string already exists in the map, if it does, then we add the current string into the sublist associated with the sorted string key, making this current string anagram of the sorted string
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] chstr = str.toCharArray();
            Arrays.sort(chstr);
            String sortedstr = new String(chstr);
            if(!map.containsKey(sortedstr)){
                map.put(sortedstr, new ArrayList<>());   
            }
            map.get(sortedstr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
