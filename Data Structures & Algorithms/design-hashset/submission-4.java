class MyHashSet {

    private static class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    Node[] arr;

    public MyHashSet() {
        arr = new Node[1000];
    }

    public void add(int key) {

        int bucket = key % 1000;

        if(arr[bucket] == null) {
            arr[bucket] = new Node(key);
            return;
        }

        Node curr = arr[bucket];
        Node parent = null;

        while(curr != null) {

            if(curr.val == key) {
                return;
            }

            parent = curr;

            if(key < curr.val) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        if(key < parent.val) {
            parent.left = new Node(key);
        }
        else {
            parent.right = new Node(key);
        }
    }

    public void remove(int key) {

        int bucket = key % 1000;

        Node curr = arr[bucket];
        Node parent = null;

        // Find node
        while(curr != null && curr.val != key) {

            parent = curr;

            if(key < curr.val) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        // Not found
        if(curr == null) {
            return;
        }

        // Case 1 + 2:
        // Zero child or one child
        if(curr.left == null || curr.right == null) {

            Node child =
                (curr.left != null) ? curr.left : curr.right;

            // Root of bucket
            if(parent == null) {
                arr[bucket] = child;
            }

            else if(parent.left == curr) {
                parent.left = child;
            }

            else {
                parent.right = child;
            }

            return;
        }

        // Case 3:
        // Two children
        Node successor = curr.right;
        Node successorParent = curr;

        while(successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }

        // Replace value
        curr.val = successor.val;

        // Delete successor
        if(successorParent.left == successor) {
            successorParent.left = successor.right;
        }

        else {
            successorParent.right = successor.right;
        }
    }

    public boolean contains(int key) {

        int bucket = key % 1000;

        Node curr = arr[bucket];

        while(curr != null) {

            if(curr.val == key) {
                return true;
            }

            if(key < curr.val) {
                curr = curr.left;
            }

            else {
                curr = curr.right;
            }
        }

        return false;
    }
}