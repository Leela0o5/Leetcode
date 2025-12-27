/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int flag = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = q.poll();
                if (flag == 0)
                    subList.addLast(node.val);
                else
                    subList.addFirst(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            res.add(subList);
            if (flag == 0)
                flag = 1;
            else
                flag = 0;
        }
        return res;
    }

}
