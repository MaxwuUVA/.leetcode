/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */
class Solution {
    public int hIndex(int[] citations) {

        //nums[]从后向前
        //sort
        //找到第n大的数小于n，n-1就是返回值
        Arrays.sort(citations);
        int res = 0;
        for(int i = 0;i < citations.length;i++){

            if(citations[citations.length-i-1] >= i+1){
                res++;
            }
            else{
                break;
            }

        }
        
        return res;
    }
}

