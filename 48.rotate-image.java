/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */
class Solution {
    public void rotate(int[][] matrix) {
        //2d array
        //rotate
        //一层一层遍历
        int n = matrix.length;
        for(int i = 0;i < n/2;i++){
            for(int j = i;j < n-1-i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
        
    }
}
