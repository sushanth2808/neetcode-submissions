class Node{
    Node next;
    int val;
    public Node(Node next, int val){
        this.next=next;
        this.val = val;
    }
    public Node(int val){
        this.val = val;
    }
    public Node(){}
}


class MyHashSet {
    Node[] arr;
    public MyHashSet() {
        arr=new Node[10000];
        for(int i=0;i<arr.length;i++){
            arr[i]=new Node();
        }
    }
    
    public void add(int key) {
        int k = key%10000;
        Node curr = arr[k];
        Node prev=curr;
        while(curr!=null){
            if(curr.val==key){
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        if(curr==null){
            prev.next=new Node(key);
        }
    }
    
    public void remove(int key) {
       int k = key%10000;
        Node curr = arr[k];
        Node prev=curr;
        while(curr!=null){
            if(curr.val==key){
                prev.next=curr.next;
                break;
            }
            prev=curr;
            curr=curr.next;
        }
    }
    
    public boolean contains(int key) {
        int k = key%10000;
        Node curr = arr[k].next;
        Node prev=curr;
        while(curr!=null){
            if(curr.val==key){
                return true;
            }
            prev=curr;
            curr=curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */