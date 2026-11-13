//Input: Given two strings s and t, return true if both the strings are anagrams of each other
// Anagram means two strings contain the same characters with each character appearing same number of times but can be in different order. Both strings must be of same length in order to qualify for being anagrams
class Solution {
    public boolean isAnagram(String s, String t) {
        // Brute force approach, 
        // Sort the char array equivalents of both strings, and check if the sorted char arrays are equal, if they are, then both are anagrams of each other
        // why char arrays? because strings cannot be sorted directly
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);

        return Arrays.equals(schar, tchar);
    }
}
