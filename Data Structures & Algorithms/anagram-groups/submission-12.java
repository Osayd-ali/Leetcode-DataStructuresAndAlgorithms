//Input: Given an array of strings strs, group all anagrams together into sublists
// Return output in any order
// grouping similar anagrams into a sublist and returning a list of sublists containing anagrams of each other
// Approach?
// We know that, the best way to find anagrams is to sort the string, and compare the other strings with the sorted sorted string. So two strings will be anagrams of each other, when their sorted equivalents are equal. 
// So, we pick each string from our array of strings
// then sort the string, and then build a map of this sorted string and an empty list associated with it. 
// We will only add the current string's sorted version and an empty list associated with it into our map when it wasn't already existing in the map.
// If the sorted version of the current selected string from the array, already exists in the map, then we just add the normal version of current string into the list associated with its sorted equivalent existing in the map
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Initialize a hashmap where we are going to build the anagram list maps for sorted version of strings
        Map<String, List<String>> map = new HashMap<>();
        //Start visiting each string by traversing through our strs array
        for(String s: strs){
            //build the char array equivalent of the current selected string 
            char[] chstr = s.toCharArray();
            // Now sort the string
            Arrays.sort(chstr);
            String sortedstr = new String(chstr);
            // Now add the sorted version of current string and an empty list associated with it, only when the map doesn't already contain the sorted version of current string
            if(!map.containsKey(sortedstr)){
                map.put(sortedstr, new ArrayList<>());
            }
            // then add the normal version of this current string into the list associated with the key, this is where we are building our anagram sublists
            map.get(sortedstr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
