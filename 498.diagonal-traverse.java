/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) { 
        /*if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int[] res = new int[matrix.length*matrix[0].length];
        //通过i+j的和来flatten整个二维数组
        int pos = 0,sum = 0;//一维数组的位置,和的大小
        while(sum <= matrix.length+matrix[0].length-2){
            int i = 0;
            while(i <= sum){
                int row = sum%2 == 0 ? i:sum-i;
                int line = sum%2 == 0 ? sum-i:i;
                if(line > matrix.length-1 || row > matrix[0].length - 1){
                     i++;
                     continue;
                }
                res[pos++] = matrix[line][row];
                i++;
            }
            sum++;
        }
        return res;*/
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }   
        int row = 0,col = 0,n = matrix.length,m = matrix[0].length,mod = 0;
        int[][] dir = {{-1,1},{1,-1}};
        int[] res = new int[n*m];
        for(int i = 0;i < n*m;i++){
            res[i] = matrix[row][col];
            row += dir[mod][0];
            col += dir[mod][1];
            if(row >= n){ col += 2;row = n-1;mod = 1 - mod;}
            if(col >= m){ row += 2;col = m-1;mod = 1 - mod;}
            if(row < 0 ){ row = 0;mod = 1 - mod;}
            if(col < 0 ){ col = 0;mod = 1 - mod;}
        }
        
        return res;
        
    }
}

