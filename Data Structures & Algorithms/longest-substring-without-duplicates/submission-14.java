//Input: We are given a string s, 
// find the length of the longest substring without duplicate characters. 
// a substring is a contiguous sequence of characters within a string
// so as we are asked to find a contiguous sequence of characters within a string without duplicates and returning the longest of such substring, we can easily implement the dynamic sliding window pattern here. 
//Initially the max length of distinct char substring would be 1, as we would need to return 1 if string contains all the same characters. 
// As we need to build substring with no duplicate characters, we will store the characters of our substring in a hashset to avoid duplicates. 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Initializing the state of our window
        int length = 0;
        // Initializing the left reference to the 0th character of the string
        int left = 0;
        Set<Character> set = new HashSet<>();
        //right reference will be used to explore the remaining characters, and extend our dynamic window everytime it visits a unique character as this is satisfying our condition.
        for(int right = 0; right<s.length(); right++){
            //as long as our set contains duplicates, we remove the current value from our set and increment our left reference
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            length = Math.max(length, set.size());
        }
        return length;
    }
}
