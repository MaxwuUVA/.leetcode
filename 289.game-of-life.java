/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */
class Solution {
    public void gameOfLife(int[][] board) {
        //2d array
        //状态机
        int[][] dir = {
            {-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}
        };
        int dietodie = 0;
        int livetolive = 1;
        int livetodie = 2;
        int dietolive = 3;
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                int count  = 0;
                for(int k = 0;k < dir.length;k++){
                    int col = i + dir[k][0];
                    int row = j + dir[k][1];
                    if(col >= 0 && col < board.length && row >= 0 && row < board[0].length){
                       if(board[col][row] > 0 && board[col][row] < 3){
                           count++;
                       }    
                    }
                }
                if(board[i][j] == 0){
                    if(count == 3){
                        board[i][j] = dietolive;
                    }
                    else{
                        board[i][j] = dietodie;
                    }
                }else if(board[i][j] == 1){
                    if(count == 2 || count == 3){
                        board[i][j] = livetolive;
                    }
                    else{
                        board[i][j] = livetodie;
                    }
                }
            }
        }
       for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                board[i][j] %= 2;
            }
        }
        
    }
}

