//Input: Given a string s, return true if s is a palindrome
// A palindrome means a string will spell the same forwards and backwards ignoring the white spaces and specical characters. 
// So edge case, when identifying if the input string is a palindrome or not, first clear all the white spaces and disregard any special characters, only build a string consisting of letters and numbers. Also palindrome is case insensitive, so to address this, convert all the characters into a consistent casing format 
// Algorithm to identify if the string is palindrome,
// Use a two pointer approach, left pointer will point to the first letter and the right pointer will point to the last letter
// As long as the characters at both indices are equal keep incrementing left pointer and keep decrementing right pointer, once all the characters are visited return true 
// else if at any point, characters at left pointer and right pointer are not equal, return false exactly at that point, since string cannot be palindrome and there is no point exploring other indices
class Solution {
    public boolean isPalindrome(String s) {
        // To build cleaned version of our string we will do it in a string builder object then make a new string out of it
        StringBuilder sb = new StringBuilder();
        // Access each character in the char array version of the input string
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        char[] cleanedstr = sb.toString().toCharArray();
        int left = 0;
        int right = cleanedstr.length-1;
        while(left<right){
            if(cleanedstr[left] == cleanedstr[right]){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
