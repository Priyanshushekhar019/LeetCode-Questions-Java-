class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int cols=matrix[0].length-1;
        int rows=0;
        while(rows<matrix.length && cols>=0){
            if(matrix[rows][cols]==target){
                System.out.print("Key found at("+rows+","+cols+")");
                return true;
            }
            else if(matrix[rows][cols]<target){
                rows++;
            }
            else{
                cols--;
            }
        }
        System.out.print("Key not found");
        return false; 
    }
}