import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */
class Solution {
    public List<Integer> grayCode(int n) {         
         List<Integer> res = new ArrayList<>();
         for(int i = 0;i < (int)Math.pow(2,n);i++){
                    res.add((i>>1)^i);
        }
            return res;
     }
}

