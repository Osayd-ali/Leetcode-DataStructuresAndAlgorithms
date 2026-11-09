//Input: Given a mxn matrix array nums,
// Each row in matrix is sorted in non decreasing order
// the first integer of every row is greater than the last integer of the previous row. 
// Return true if target exists within matrix, or else false. 
// So basically, the whole matrix is sorted.
// So pick each row and do binary search on it. 
// Binary search: Two Approaches
// Approach 1 - time complexity O(m * log n)
// As each row is sorted, access each row and then do binary search for each array and check if target exists in the array
// Approach 2 - time complexity O(log(m * n)) optimal approach
// As the question mentions, first element of each row is greater than the last element of previous row. This means all the elements in the matrix are sorted 
// So convert this complete 2-d matrix into a single 1 dimensional sorted array
// Then apply binary search to find target in this 1 dimensional sorted array
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // for(int i=0; i<matrix.length; i++){
        //     int start = 0;
        //     int end = matrix[i].length - 1;
        //     while(start <= end){
        //         int mid = start + (end - start)/2;
        //         if(target == matrix[i][mid]){
        //             return true;
        //         } else if(target < matrix[i][mid]){
        //             end = mid - 1;
        //         } else {
        //             start = mid + 1;
        //         }
        //     }
        // }
        // return false;

        // Optimal approach
        // Convert 2d matrix into one whole 1 dimensional sorted array 
        // start reference for our binary search will point to 0th index
        // end reference for our binary search will point to row * col - 1 index which is typically the last index if we combine all the elements into a single 1 d array
        // for a 3 * 4 matrix, total number of elements if converted into a 1 d array would be
        // 12 elements, if we follow 0 indexed array the last index would be 11
        // so 3 * 4 - 1 = 11. 
        // Eg: input: {[1,2,4,8],
        //             [10,11,12,13],
        //             [14,20,30,40]}
        // 1 D equivalent would be: {1,2,4,8,10,11,12,13,14,20,30,40}
        // Identify the mid point of this combined array 
        // then compare the element at mid index with the target, to shift our start and end references, if element at mid equals target, then return mid 
        // How to identify element at mid index?
        //row = mid / cols Integer division by the number of columns tells which row we're in.
        //col = mid % col Modulo by the number of columns tells us which column we're in.
        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            // computing the element at mid index 
            int row = mid / cols;
            int col = mid % cols;
            if(target == matrix[row][col]){
                return true;
            } else if (target < matrix[row][col]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
