/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
        return false;
        if (root.left != null){
            return hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null){
            return hasPathSum(root.right, sum - root.val);
        }
        if (root.left == null && root.right == null){
            
        }
        return false;
    }
}

/*

       1
   -2    -3
  1  3  -2
-1

*/