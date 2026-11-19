//Input: We are given an array of heights, where each index i represents height at the ith bar. We must choose two bars i.e. two indices which can hold the maximum amount of water. Like these bars form a container and we must choose a container that holds the maximum amount of water
// return the area of the container which can hold the maximum amount of water
// so basically return the max area formed by two bars
// area = the shorter height between two bars in consideration * width(the difference of between two considered indices). 
class Solution {
    public int maxArea(int[] heights) {
        // Brute force approach
        // use a nested loop approach, to create a pair of heights and compute the area for these pair of heights, we will make a pair for every two bars present in the array.
        // the outer loop will choose the first bars, and the inner will be used to explore the second bar
        // for each outer loop's selected bar, we are pairing it up with all the remaining bars
        // then we compute the area for every pair of bars, and then choose the max area
        // area = min height of the pair of bars currently selected * difference between indices
        // int maxArea = 0;

        // for(int i=0; i<heights.length; i++){
        //     int area = 0;
        //     for(int j=i+1; j<heights.length; j++){
        //         int width = j-i;
        //         int height = Math.min(heights[i], heights[j]);
        //         area = width * height;
        //         maxArea = Math.max(maxArea, area);
        //     }
        // }
        // return maxArea;
        //Optimized approach using a convergent two pointer approach
        // when we use a convergent two pointer approach, we are already starting with the max width in terms of our max area, so now we only have to decide on a criteria of how to move our pointers so that we are moving towards a bigger area
        // so for every iteration, we will obviously compute the area for that iteration and then get the max area. then which ever bar is minimum between the current selected bars pointed by our left and right pointers, we increment or decrement that specific pointer. That is, if left bar is less than right bar, then we need to make our area bigger so increment left pointer, else when right bar is less than left bar, then decrement the right bar as we might explore a new greater bar in the next iteration that would be greater than the current left bar. 
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right){
            // compute the area first for the current selected bars and store the max area b/w current area and previous max area
            maxArea = Math.max(maxArea, (right - left) * (Math.min(heights[left], heights[right])));
            //Now we move our pointers 
            if(heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
