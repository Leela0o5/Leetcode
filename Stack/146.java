class LRUCache {
    int cap;
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val){
            this.val = val;
            this.key = key;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer, Node> m = new HashMap<>();
    public LRUCache(int cap) {
        this.cap = cap;
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node node){
        Node currAfterHead = head.next;
        head.next = node;
        node.prev = head;
        currAfterHead.prev = node;
        node.next = currAfterHead;
    }

    void delNode(Node node){
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev =  prevNode;
    }
    
    public int get(int key) {
        if(!m.containsKey(key)) return -1;
        Node node = m.get(key);
        delNode(node);
        addNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node node = m.get(key);
            node.val = value;
            delNode(node);
            addNode(node);
        } else{
            if(m.size() == cap) {
                Node node = tail.prev;
                delNode(node);
                m.remove(node.key);
            }
            Node node = new Node(key,value);
            m.put(key,node);
            addNode(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
