/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */
 class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here

        //binary search
        //再利用二维数组有序找到可能在的一维数组
        //O(m+logn) matrix是m*n的二维数组
        
        int row = findrow(matrix,target);
        
        if(row == -1) return false;
        
        return binarysearch(matrix[row],target,0,matrix[row].length-1);
        
    }
    private int findrow(int[][] matrix,int target){

        if(matrix.length == 0 || matrix[0].length == 0) return -1;
        
        int row = -1;
        
        for(int i = 0;i < matrix.length;i++){
            
            if(matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target){
                
                row = i;
                
            }
        }
        
        return row;
        
    }
    private boolean binarysearch(int[] arr,int target,int start,int end){
        
        if(start > end ) return false; 
        
        int mid = start +(end - start)/2;
        
        if(arr[mid] == target) return true;
        
        else if(arr[mid] > target)  return binarysearch(arr,target,start,mid-1);
        
        else  {
            
            return binarysearch(arr,target,mid+1,end);
            
        }
        
    }
}
