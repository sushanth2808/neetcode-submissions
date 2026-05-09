public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public  Node(int key,int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}



class LRUCache {
    

    private int capacity;
    private HashMap<Integer,Node> map;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.left = new Node(0,0);
        this.right=new Node(0,0);
        this.capacity=capacity;
        this.left.next=this.right;
        this.right.prev=this.left;
    }
    
    public int get(int key) {
        Node curr=null;
        if(map.containsKey(key)){
            curr = map.get(key);
            curr.prev.next = curr.next;
            curr.next.prev=curr.prev;

        right.prev.next=curr;
        curr.prev=right.prev;
        curr.next=right;
        right.prev=curr;
        return curr.val;
        }
        return -1;




    }
    
    public void put(int key, int value) {
        Node curr=null;
       if(map.containsKey(key)){
        curr = map.get(key);
        curr.val=value;
        curr.prev.next = curr.next;
        curr.next.prev=curr.prev;
       }
       else{
        if(map.size()==capacity){
            Node node = left.next;
            left.next = node.next;
            node.next.prev=left;
            map.remove(node.key);
        }
        curr= new Node(key,value);
        map.put(key,curr);
        
       }
        right.prev.next=curr;
        curr.prev=right.prev;
        curr.next=right;
        right.prev=curr;
       }   
}
