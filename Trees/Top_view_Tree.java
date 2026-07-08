/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
 class pair{
        Node node;
        int hd;
        pair(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }
class Solution {
   
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.offer(new pair(root,0));
        if(root == null) return ans;
        while(!q.isEmpty()){
            pair p = q.poll();
            int hd = p.hd;
            Node node = p.node;
             if (!map.containsKey(hd))
                map.put(hd, node.data);
            
             if (node.left != null)
                q.offer(new pair(node.left, hd - 1));

            if (node.right != null)
                q.offer(new pair(node.right, hd + 1));
            
        }
        
        for (int value : map.values())
            ans.add(value);
        return ans;
              
        
    }
}
