/*
 * @lc app=leetcode id=1080 lang=java
 *
 * [1080] Insufficient Nodes in Root to Leaf Paths
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {

        if(root == null) return root;
        if(root.left == null && root.right == null) 
          return root.val < limit ? null:root;//判断叶节点是否小于limit
        root.left = sufficientSubset(root.left, limit-root.val);
        root.right = sufficientSubset(root.right, limit-root.val);
        if(root.left == null && root.right == null)
          return null;//非叶节点如果子节点均为null，那么这个节点也要删除
        return root;//返回满足的非叶节点
    }
}

