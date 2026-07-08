import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int maxSum = Integer.MIN_VALUE;
        int ansLevel = 1;     
        int currentLevel = 1;
        
        while (!q.isEmpty()) {
            int nodesAtCurrentLevel = q.size();
            int currentLevelSum = 0; 
            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                TreeNode currentNode = q.poll();
                currentLevelSum += currentNode.val;
                
                if (currentNode.left != null) q.offer(currentNode.left);
                if (currentNode.right != null) q.offer(currentNode.right);
            }
            
            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                ansLevel = currentLevel;
            }
            currentLevel++;
        }
        
        return ansLevel;
    }
}
