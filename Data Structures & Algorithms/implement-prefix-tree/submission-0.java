class PrefixTree {
    class Node{
        Map<Character,Node> child = new HashMap<>();
        boolean isEnd;
    }
    Node root;
    public PrefixTree() { 
       root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!node.child.containsKey(c)){
                node.child.put(c,new Node());
            }

            node = node.child.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(node.child.containsKey(c)){
                node = node.child.get(c);
            }
            else{return false;}
        }
        if(node.isEnd){return true;}
        return false;
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(node.child.containsKey(c)){
                node = node.child.get(c);
            }
            else{return false;}
        }
        return true;
        }
}
