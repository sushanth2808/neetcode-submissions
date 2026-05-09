class Solution {

    List<String> digitMap = List.of("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        findCombinations(digits,0,res,"");
        return res;
    }

    private void findCombinations(String digits, int index, List<String> res,String s){
        if(index==digits.length()){
            if(s.length()!=0){
                res.add(s);
            }
             return;
        }
        int number = digits.charAt(index)-'0'; 
        String numchars = digitMap.get(number);
        for(int i=0;i<numchars.length();i++){
            findCombinations(digits,index+1,res,s+numchars.charAt(i));
        }
    }



    // private void buildNumberDigitMap(String digits, Map<Character,List<Character>> map){
    //     for(int i=0;i<digits.length();i++){
    //         if(!map.containsKey(digits.charAt(i))){
    //             map.put(digits.charAt(i),list.get(i));
    //         }
    //     }
    // }
}
