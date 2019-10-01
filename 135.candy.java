import java.util.Arrays;

/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */
class Solution {
    public int candy(int[] ratings) {
        //array
        //greedy
        if(ratings == null || ratings.length == 0){
            return 0;
        }
        int len = ratings.length;
        int[] rate = new int[len];
        Arrays.fill(rate,1);
        for(int i = 1;i<len;i++){
            if(ratings[i] > ratings[i-1]){
                rate[i] = rate[i-1]+1;
            }
        }
        for(int i = len-1;i >= 1;i--){
            if(ratings[i-1] > ratings[i] && rate[i-1] <= rate[i]){
                rate[i-1] = rate[i]+1;
            }
        }
        int res = 0;
        for(int n:rate){
           res += n;
        }
        return res;
    }
}

