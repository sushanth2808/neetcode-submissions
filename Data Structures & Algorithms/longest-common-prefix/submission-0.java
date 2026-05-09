class Node {
    Node[] arr = new Node[26];
    int count;
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Node node = new Node();
        for(String str : strs){
            Node curr =node;
            for(int i=0;i<str.length();i++){
                int index  = str.charAt(i)-'a';
                if(curr.arr[index]==null){
                    curr.arr[index]=new Node();
                }
                curr=curr.arr[index];
                curr.count++;
            }
        }

        Node curr = node;
        StringBuilder s = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            int index= strs[0].charAt(i)-'a';
            if(curr.arr[index]!=null && curr.arr[index].count==strs.length){
                s.append(strs[0].charAt(i));
                curr=curr.arr[index];
            }
            else{
                break;
            }
        }

       return s.toString();
    }
}