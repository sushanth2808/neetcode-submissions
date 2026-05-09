class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int p1=0;
        int p2=row-1;
        int min=0;
        while(p1<=p2){
            int mid=p1+(p2-p1)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            else if(target>matrix[mid][0]){
                p1=mid+1;
                min=mid;
            }
            else{
                p2=mid-1;
            }
        }

         p1 = 0;
         p2=col-1;

        while(p1<=p2){
            int mid=p1+(p2-p1)/2;
            if(matrix[min][mid]==target){
                return true;
            }
            else if(target>matrix[min][mid]){
                p1=mid+1;
            }
            else{
                p2=mid-1;
            }
        }
        return false;

    }
}
