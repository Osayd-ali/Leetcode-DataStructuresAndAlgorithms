//Input: Given a mxn matrix array nums,
// Each row in matrix is sorted in non decreasing order
// the first integer of every row is greater than the last integer of the previous row. 
// Return true if target exists within matrix, or else false. 
// So basically, the whole matrix is sorted.
// So pick each row and do binary search on it. 
// Binary search: Two Approaches
// Approach 1 - time complexity O(m * log n)
// As each row is sorted, access each row and then do binary search for each array and check if target exists in the array
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            int start = 0;
            int end = matrix[i].length - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(target == matrix[i][mid]){
                    return true;
                } else if(target < matrix[i][mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}
