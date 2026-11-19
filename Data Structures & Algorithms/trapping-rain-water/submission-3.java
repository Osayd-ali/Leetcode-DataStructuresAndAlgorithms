//Input: Given an array of non negative integers height, which represent an elevation map. 
// each value height[i] represents the height of a bar, which has a width 1. 
// return the total amount of water that can be trapped between the bars. 
// In container with most water, the bars did not have a width, it was just singular line. And we needed to form the container which could hold the maximum amount of water. 
// but here, we would want to know the total amount of water that can be trapped between multiple bars. 
// Basically the count of empty squares between the non empty bars. 
// To calculate the amount of water trapped at a position, the greater element to the left l and the greater element to the right r of the current position are crucial. The formula for the trapped water at index i is given by: min(height[l], height[r]) - height[i]. 
// For example in heights {0,2,0,3,1,0,1,3,2,1}
// if we were wanting to know how much water is trapped for index 2, it would be, choosing the min height between the left bar of current index and the right bar of current index, minus, the height at current index.
// So Algorithm would be, calculate trapped water at each index and keep adding it into our total trapped water reference, finally return the sum of all trapped waters which would be our total trapped water reference holding. 
// only in the case of height at left and height at right of the current index, trapped water can be computed. so until we find elements greater than current height, we would be moving our pointers. 
// Once we've found greater elements at left and right of the current index, we will take the min of both and subtract it with current height, to deduce how much water can be trapped. 
class Solution {
    public int trap(int[] height) {
        // if(height == null || height.length == 0){
        //     return 0;
        // }
        // int maxTrap = 0;

        //Computing trapping water at each height
        // for(int i=0; i<height.length; i++){
        //     // we will start our two pointer approach
        //     // left reference will be pointing to the left index of the current
        //     int leftMax = height[i];
        //     int rightMax = height[i];
        //     // Exploring all the values at the left of current i, to get the greatest height on left
        //     // Compute leftMax by scanning from 0 to i
        //     for(int j=0; j<i; j++){
        //         leftMax = Math.max(leftMax, height[j]);
        //     }
        //     // Exploring all the heights coming after the current i, to get the greatest height
        //     // Compute rightMax by scanning from i+1 to height.length
        //     for(int j=i+1; j<height.length; j++){
        //         rightMax = Math.max(rightMax, height[j]);
        //     }
        //     // Once we have gotten the greatest heights existing on the left and the right hand side of the current selected index
        //     // we compute the trapped water for the current index and add it to our total trapped water
        //     maxTrap += Math.min(leftMax, rightMax) - height[i];
        // }
        // return maxTrap;

        //Instead of recomputing the greatest left and right heights for each index, we can precompute these values once and store it into prefix and suffix arrays
        // we build two arrays leftMax[i] = tallest bar from start up to i
        // rightMax[i] = tallest bar from the end up to index i
        // Once we have this, the trapped water at position i is simply
        // min(leftMax[i], rightMax[i]) - height[i];

        // if empty input array then return 0
        int n = height.length;
        if(n == 0){
            return 0;
        }
        
        // Create array to store the greatest bar at the left side for each index
        // naturally there is nothing on the left of first index in the original array so we just assign the first element of our prefix array to the first element in the original array
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        // Now start computing the greatest height coming on the left side for each index from the original array
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // The last element in our suffix array will point to the last element in the original array, since there is no greater element to be found on the right hand side of the last element in original array 
        rightMax[n-1] = height[n-1];
        //Now compute the greatest heights coming on the right side for each index of our original array
        // it would be the max value of, the right max computed previously at the next index, and the current height which ever is greater. 

        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Now we are calculating trapped water at each index and keep adding it to our total trapped water. We are calculating by simply choosing the minimum of ith element at leftMax prefix array which would already be pointing to the greatest element coming on the left of the ith index which we computed before and ith element at rightMax suffix array which would already be pointing to the greatest element coming on the right of the ith index which we computed before. and then subtract it with current ith height. 
        int totalTrap = 0;

        for(int i=0; i<n; i++){
            totalTrap += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalTrap;
    }
}
