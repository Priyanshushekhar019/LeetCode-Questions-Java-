/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findRoot(root);
        return maxSum;
    }
    public int findRoot(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,findRoot(root.left));
        int right=Math.max(0,findRoot(root.right));
        int currentsum=left+right+root.val;
        maxSum=Math.max(maxSum,currentsum);
        return root.val+Math.max(left,right);
    }
}