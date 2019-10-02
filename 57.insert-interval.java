import java.util.Comparator;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[] tmp = newInterval.clone();
        for(int i = 0;i < intervals.length;i++){
            if(tmp[0] <= intervals[i][1] && tmp[1] >= intervals[i][0]){
                tmp[0] = intervals[i][0] < tmp[0]?intervals[i][0]:tmp[0];
                tmp[1] = intervals[i][1] > tmp[1]?intervals[i][1]:tmp[1];
                n--;
            }
        }
        int pos = 0;
        int[][] res = new int[n+1][2];
        for(int j = 0;j < intervals.length;j++){
            if(tmp[0] <= intervals[j][1] && tmp[1] >= intervals[j][0]){
                continue;
            }
            else{

                res[pos++] = intervals[j];

            }
        }
        res[pos] = tmp;
        Arrays.sort(res, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        return res;
    }
}

