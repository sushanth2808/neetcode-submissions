class WordDictionary {
    class Node{
        Node[] children = new Node[26];
        boolean end;
    }
    private Node root;
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null){
                curr.children[c-'a']=new Node();
            }
            curr = curr.children[c-'a'];
        }
        curr.end=true;
    }

    public boolean search(String word) {
        return isWord(word,0,root);
    }

    private boolean isWord(String word,int index,Node curr){
        if(index==word.length()){
            return curr.end;
        }
        if(word.charAt(index)!='.'){
            int ascii = word.charAt(index)-'a';
            Node node = curr.children[ascii];
            if(node==null){return false;}
            return isWord(word,index+1,node);
        }else{
            for(int i=0;i<26;i++){
                Node node = curr.children[i];
                if(node!=null){
                     if(isWord(word,index+1,node)){
                        return true;
                     }
                }
            }
            return false;
        }
    }
}
