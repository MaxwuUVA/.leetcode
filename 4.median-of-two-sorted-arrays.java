/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int l1 = nums1.length,l2=nums2.length,left = (l1+l2+1)/2,right = (l1+l2+2)/2;
        
        //trick:中位数如果left+right 为基数个时 为 （left+right）/2 + 1 个为中位数 
        //为偶数时 （left+right）/ 2 和 （left+right）/2 + 1的平均数
        //我们设left = (l1+l2+1)/2 奇数时和right相等，偶数时 向下取整left = (left+right)/2
        //避免了分奇偶讨论的情况；
        return (findKth2Array(nums1,nums2,left,0,0)+findKth2Array(nums1,nums2,right,0,0))/2.0;
    }
    private double findKth2Array(int[] num1,int[] num2,int k,int start1,int start2){
        
        //对n1,n2分别取前k/2，比较大小，去掉小的那部分，再对剩下的两个数组做find(k-k/2)操作
        //直到k = 0
        //如果剩下的不足k/2，那么去掉前一个的k/2
        //如果k = 1，比较start1和start2的值就可以
        //如果start > length 那只需要找剩下数组的第k个元素
        
        if(start1 > num1.length - 1) return num2[start2+k-1];
        
        if(start2 > num2.length - 1) return num1[start1+k-1];
        
        if(k == 1) return num1[start1] < num2[start2] ? num1[start1] : num2[start2];
        
        if(num1.length - start1 < k/2) return findKth2Array(num1,num2,k-k/2,start1,start2+k/2);
        
        if(num2.length - start2 < k/2) return findKth2Array(num1,num2,k-k/2,start1+k/2,start2);
        
        int valnum1 = num1[k/2+start1-1];
        
        int valnum2 = num2[k/2+start2-1];
        
        if(valnum1 > valnum2){
            
            return findKth2Array(num1,num2,k-k/2,start1,start2+k/2);
            
        }
        else{
            
            return findKth2Array(num1,num2,k-k/2,start1+k/2,start2);
            
        }
    }
}

