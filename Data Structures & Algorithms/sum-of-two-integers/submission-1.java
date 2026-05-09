class Solution {
    public int getSum(int a, int b) {
        int res =0;
        int carry=0;
        for(int i=0;i<32;i++){
            int first = (a>>i & 1);
            int second = (b>>i & 1);
            if((first & second)==1){
                if(carry==1){
                    res=res | (1<<i);
                }
                carry=1;
            }
            else if((first | second)==1){
                if(carry==1){
                    carry=1;
                }
                else{
                    res=res|(1<<i);
                    carry=0;
                }
            }
            else{
                res = res | (carry<<i);
                carry=0;
            }  
        }
        return res;
    }
}
