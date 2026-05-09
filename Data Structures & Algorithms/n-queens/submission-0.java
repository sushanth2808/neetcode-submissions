class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        Set<Integer> vset = new HashSet<>();
        solvePuzzle(n,0,res,list,diag1,diag2,vset);
        return res;
    }

    private void solvePuzzle(int n,int index,List<List<String>> res, List<String> list,Set<Integer> set,Set<Integer> diag2,Set<Integer> vset){
        if(index==n){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(validPosition(index,i,vset,set,diag2)){
                diag2.add(index+i);
                set.add(index-i);
                vset.add(i);
                String s = buildPosition(i,n);
                list.add(s);
                solvePuzzle(n,index+1,res,list,set,diag2,vset);
                list.remove(list.size()-1);
                diag2.remove(index+i);
                set.remove(index-i);
                vset.remove(i);
            }
        }
    }

    private boolean validPosition(int row, int col,Set<Integer> vset,Set<Integer> set,Set<Integer> diag2){
        if(set.contains(row-col) || diag2.contains(row+col) ){
            return false;
        }
        if(vset.contains(col)){return false;}
        return true;
    }

    private String buildPosition(int pos,int n){
        String s ="";
        for(int j=0;j<n;j++){
            if(j!=pos){s+=".";} 
            else{s+="Q";}
        }
        return s;
    }


}
