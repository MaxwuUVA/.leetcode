/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        //array
        //interval
        //Comparator
        //ArrayList重构
        if(intervals.length == 0) return new int[0][0];
        //对intervals的首位数字排序
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int[] tmp = new int[2];
        //tmp中存第0个intervals
        tmp[0] = intervals[0][0];
        tmp[1] = intervals[0][1];  
        for(int i = 1 ;i < intervals.length;i++){
            //合并overlapintervals
            if(intervals[i][0] <= tmp[1]){
                tmp[1] = intervals[i][1] > tmp[1]?intervals[i][1]:tmp[1];
            }
            //没有overlap，tmp换成下一个interval
            else{
                res.add(tmp);
                tmp = intervals[i];
                
            }
            
        }
        res.add(tmp);
        return res.toArray(new int[res.size()][2]);
    }
}

