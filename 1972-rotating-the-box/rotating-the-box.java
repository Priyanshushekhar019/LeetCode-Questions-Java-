class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length;
        int n=boxGrid[0].length;
        char[][] res =new char[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][m-1-i]=boxGrid[i][j];
            }
        }
        for(int j=0;j<m;j++){
            int emp=n-1;
            for(int i=n-1;i>=0;i--){
                if(res[i][j]=='*'){
                    emp=i-1;
                }
                else if(res[i][j]=='#'){
                    char temp=res[i][j];
                    res[i][j]='.';
                    res[emp][j]=temp;
                    emp--;
                }
            }
        }
        return res;
    }
}