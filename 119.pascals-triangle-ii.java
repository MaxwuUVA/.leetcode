/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //dp
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            res.add(1);
            for(int j = i-1; j > 0; j--) {
                res.set(j, res.get(j-1) + res.get(j));//updown dp[i] = dp[i-1]+dp[i]
                                                      // list.set
            }
        }
        return res;
    }
}

