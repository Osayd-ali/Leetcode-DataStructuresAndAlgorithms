//Input: Given two strings s and t, return true if both the strings are anagrams of each other
// Anagram means two strings contain the same characters with each character appearing same number of times but can be in different order. Both strings must be of same length in order to qualify for being anagrams
class Solution {
    public boolean isAnagram(String s, String t) {
        // Brute force approach, 
        // Sort the char array equivalents of both strings, and check if the sorted char arrays are equal, if they are, then both are anagrams of each other
        // why char arrays? because strings cannot be sorted directly
        // char[] schar = s.toCharArray();
        // char[] tchar = t.toCharArray();
        // Arrays.sort(schar);
        // Arrays.sort(tchar);

        // return Arrays.equals(schar, tchar);
        // Time complexity for the above approach would be 2 * O(n logn) -> O(n logn). 
        // More optimal approach? as the question says, both strings must have same chars, appearing same number of times. there is an opportunity for us to create a frequency map for each character and their number of occurrences for both the strings
        // we could just check for the equality for frequency map equivalents of both strings
        // this would run in O(n) time instead of our previous approach which was O(n logn)
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c: s.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char c: t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        return map1.equals(map2);
    }
}
