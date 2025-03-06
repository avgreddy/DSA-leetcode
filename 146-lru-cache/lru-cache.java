class CDLLNode{
    int key;
    int val;
    CDLLNode prev,next;
    public CDLLNode(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class CDLL{
    CDLLNode head;
    public CDLL(){
        head = null;
    }
    CDLLNode insAtBegin(int key,int val){
        CDLLNode nn = new CDLLNode(key,val);
        nn.prev = nn;
        nn.next = nn;
        if(head == null){
            head = nn;
            return head;
        }
        CDLLNode last = head.prev;
        nn.next = head;
        head.prev = nn;
        nn.prev = last;
        last.next = nn;
        head = nn;
        return head;
    }
    int delLastNode(){
        if(head == null){
            return -1;
        }
        if(head.next == head){
            return head.key;
        }
        CDLLNode last = head.prev;
        CDLLNode beforeLast = last.prev;
        head.prev = beforeLast;
        beforeLast.next = head;
        return last.key;
    }
    void moveAtFront(CDLLNode nodeToMove){
        if(nodeToMove == head){
            return;
        }
        CDLLNode temp = nodeToMove;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        CDLLNode last = head.prev;
        temp.next = head;
        head.prev = temp;
        temp.prev = last;
        last.next = temp;
        head = temp;
    }
}
class LRUCache {
    int capacity;
    CDLL list;
    Map<Integer,CDLLNode> mp;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new CDLL();
        mp = new HashMap<>();
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }
        CDLLNode node = mp.get(key);
        int res = node.val;
        list.moveAtFront(node);
        return res;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            CDLLNode node = mp.get(key);
            node.val = value;
            list.moveAtFront(node);
        }
        else{
            if(mp.size() < capacity){
                CDLLNode node = list.insAtBegin(key,value);
                mp.put(key,node);
            }
            else{
                int del = list.delLastNode();
                mp.remove(del);
                CDLLNode node = list.insAtBegin(key,value);
                mp.put(key,node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */