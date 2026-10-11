class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int p1=0;
        int p2=matrix.length-1;
        int row = -1;
        while(p1<=p2){
            int mid = p1+(p2-p1)/2;
            if(matrix[mid][0]<target){
                row=mid; 
                p1+=1;
            }
            else if(matrix[mid][0]>target){
                p2-=1;
            }
            else{
                return true;
            }
        }
        if(row==-1){
            return false;
        }

        p1=0;
        p2=matrix[0].length-1;
        while(p1<=p2){
            int mid = p1+(p2-p1)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            if(matrix[row][mid]<target){
                p1+=1;
            }
            else{
                p2-=1;
            }
        }
        return false;
    }
}
