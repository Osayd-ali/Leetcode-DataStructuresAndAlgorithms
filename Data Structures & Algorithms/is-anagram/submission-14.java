//Input: given two strings
// return true if both the strings are anagrams of each other
// Anagram means, both strings contain the same characters, repeating same number of times, but can be in different order
// Brute force approach would be
// Use a nested loop approach, convert both strings into char array equivalents 
// sort these character arrays
// check if both arrays are equal, if they are then return true
// This happens in 2 * O(n logn) since sorting step is involved
class Solution {
    public boolean isAnagram(String s, String t) {
        // char[] schar = s.toCharArray();
        // char[] tchar = t.toCharArray();

        // Arrays.sort(schar);
        // Arrays.sort(tchar);

        // return Arrays.equals(schar, tchar);
        // more efficient way, instead of sorting which is slow 
        // what we can do is, we try to create a frequency map for each string's character and their number of occurrence, if the character frequency maps of both strings are equal then return true.
        // Edge case: If both the strings are of different lengths, then they can never be anagrams return false
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        for(char c: s.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        for(char c: t.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        return map1.equals(map2);
    }
}
