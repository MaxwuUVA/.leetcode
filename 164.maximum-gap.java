/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length == 0) return 0;
        //array
        //bucket sort;
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        int len = nums.length;
        for(int n:nums){
            min = Math.min(min,n);
            max = Math.max(max,n);
        }
        int bucket = (max-min)/len+1;//每个bucket的容量eg:[0,2...10] 10-0/6+1 = 2
        int count = (max-min)/bucket+1;//bucket的个数 eg:[0,2...10] 10-0/2+1 = 6
        Integer[] ma = new Integer[count];//bucket的最大值
        Integer[] mi = new Integer[count];//bucket的最小值
        for(int n:nums){
            int cnt = (n-min)/bucket;//第几个bucket
           if(ma[cnt] == null) ma[cnt]=n;//初始化
           if(mi[cnt] == null) mi[cnt]=n;//初始化
              ma[cnt] = Math.max(ma[cnt],n);
              mi[cnt] = Math.min(mi[cnt],n);
        }
        int res = 0,pre = 0;
        for(int i = 1;i < count;i++){
            if(ma[i] == null || mi[i] == null) continue;
            res = Math.max(res,mi[i]-ma[pre]);//证明：若存在a,b 在一个bucket内且b-a值为排序后相邻最大
                                              // 则必须满足a.每个bucket里面必须有值，否则存在最大 > 一个bucket range
                                              // a条件与bucket里面有a,b两个值矛盾，所以不存在a，b
                                              // 又可以推出最大值在bucket的最小值和上一个的最大值的差之间产生
                                              // 因为a,b不在一个bucket
            pre = i;
        }
        return res;
    }
}

