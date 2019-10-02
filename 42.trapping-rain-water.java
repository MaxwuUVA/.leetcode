/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */
class Solution {
    public int trap(int[] height) {
        //array
        //two pointer
        int left = 0, right = height.length-1,res = 0,cur = 0;
        while(left < right){
            if(height[left] < height[left+1]){
                left++;
                continue;
            }
            if(height[right] < height[right-1]){
                right--;
                continue;
            }
            if(height[left] < height[right]){
                cur = left+1;
                while(height[left] > height[cur]){
                    res += height[left]-height[cur];
                    cur++;
                }
                left = cur;
            }
            else{
                cur = right-1;
                while(height[right] > height[cur]){
                    res += height[right]-height[cur];
                    cur--;
                }
                right = cur;
            }
        }

        return res;
    }
}

