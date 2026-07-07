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
    public static boolean sameTree(TreeNode p,TreeNode q){
        if(p == null || q==null) return p==q;
        return p.val==q.val && sameTree(p.left,q.left) && sameTree(p.right,q.right);

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(sameTree(root,subRoot)) return true;
        return (isSubtree(root.left,subRoot) ||  isSubtree(root.right,subRoot));
    }
}
