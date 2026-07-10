class Solution {

    int preIdx = 0;

    public int searchRoot(int[] inorder, int l, int r, int val) {
        for (int i = l; i <= r; i++) {
            if (inorder[i] == val)
                return i;
        }
        return -1;
    }

    public TreeNode solve(int[] preorder, int[] inorder, int l, int r) {

        if (l > r)
            return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);

        int rootIdxInorder = searchRoot(inorder, l, r, root.val);

        root.left = solve(preorder, inorder, l, rootIdxInorder - 1);
        root.right = solve(preorder, inorder, rootIdxInorder + 1, r);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, inorder.length - 1);
    }
}
