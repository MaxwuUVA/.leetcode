import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {

        //具体思路很简单就是验证每一行每一列每一个方块内都没有重复数字
        for(int i = 0;i < 9;i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for(int j = 0;j < 9;j++){
                if(board[i][j]!='.' && rows.contains(board[i][j]))
                   return false;
                if(board[j][i]!='.' && cols.contains(board[j][i]))
                   return false;
                //trick验证方块内是否满足
                //board[j/3][j%3]对于第一个cube来说
                //下一个左面的board[j/3][j%3+3*(i%3)];
                //下一个下面的board[j/3+3*(i/3)][j%3+3*(i%3)];
                //这样就能形成一个先从左到右再从上到下遍历9个cube的循环
                int cubeRow = 3*(i/3) + j/3;
                int cubeCol = 3*(i%3) + j%3;
                if(board[cubeRow][cubeCol]!='.' && cube.contains(board[cubeRow][cubeCol]))
                   return false;
                else
                {
                    rows.add(board[i][j]);
                    cols.add(board[j][i]);
                    cube.add(board[cubeRow][cubeCol]);
                }
             }
         }

        return true;
        
    }
}

