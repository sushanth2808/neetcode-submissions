class PrefixTree {
    Node root;
    private static class Node{
        Node[] child = new Node[26];
        boolean isWord;
    }

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            int index = c-'a';
            if(node.child[index]==null){
                node.child[index]=new Node();
            }
            node = node.child[index];
        }
        node.isWord=true;
    }

    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            int index = c-'a';
            if(node.child[index]==null){
                return false;
            }
            node = node.child[index];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
                Node node = root;
        for(char c : prefix.toCharArray()){
            int index = c-'a';
            if(node.child[index]==null){
                return false;
            }
            node = node.child[index];
        }
        return true;
    }
}
