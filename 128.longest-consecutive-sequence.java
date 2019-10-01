import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */
class Solution {
        class UnionFind {
           private int count = 0;
           private int[] parent, rank;
           
           public UnionFind(int n) {
               count = n;
               parent = new int[n];
               rank = new int[n];
               for (int i = 0; i < n; i++) {
                   parent[i] = i;
               }
           }    
           public int find(int p) {
               while (p != parent[p]) {
                   parent[p] = parent[parent[p]];    // path compression by halving
                   p = parent[p];
               }
               return p;
           }
           
           public void union(int p, int q) {
               int rootP = find(p);
               int rootQ = find(q);
               if (rootP == rootQ) return;
               if (rank[rootQ] > rank[rootP]) {
                   parent[rootP] = rootQ;
               }
               else {
                   parent[rootQ] = rootP;
                   if (rank[rootP] == rank[rootQ]) {
                       rank[rootP]++;
                   }
               }
               count--;
           }
           
           public int count() {
               return count;
           }
        }
    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind(nums.length);
        if(nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])) continue;
            if(map.containsKey(nums[i]-1)){
                uf.union(i, map.get(nums[i]-1));
            }
            if(map.containsKey(nums[i]+1)){
                uf.union(i, map.get(nums[i]+1));
            }
            map.put(nums[i],i);  
        }
        int[] counts = new int[nums.length];
        for(int j = 0;j < nums.length;j++){
            counts[uf.find(j)]++;
        }
        int res = 0;
        for(int k = 0;k < nums.length;k++){
            res = Math.max(counts[k],res);
        }
        return res;
    }
}

