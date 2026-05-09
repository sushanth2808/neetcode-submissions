class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int p1=0;
        int p2=row*col-1;
        int min=0;

        while(p1<=p2){
            int mid = (p1+p2)/2;
            int r = mid/col;
            int c = mid%col;
            if(target==matrix[r][c]){
                return true;
            }
            if(target>matrix[r][c]){
                p1=mid+1;
            }
            else{
                p2=mid-1;
            }
        }
       return false; 
    }
}
