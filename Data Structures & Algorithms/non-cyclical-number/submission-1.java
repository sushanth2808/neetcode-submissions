class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum =0;
        set.add(n);
        while(true){
            int rem = n%10;
            n = n/10;
            sum=sum+rem*rem;
            if(n==0 && sum==1){
                return true;
            }
            if(n==0){
                if(set.contains(sum)){return false;}
                set.add(sum);
                n=sum;
                sum=0;
            }
        }
    }
}
