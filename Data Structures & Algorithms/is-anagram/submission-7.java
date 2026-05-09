class Solution {
    public boolean isAnagram(String s, String t) {
        //bruteforce
        //sort both the strings and check if equal or not
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        String s1 = new String(schar);
        String t1=new String(tchar);
        if(s1.equals(t1)){
            return true;
        }
        return false;

    }
}
