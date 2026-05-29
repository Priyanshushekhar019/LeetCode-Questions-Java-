class Solution {
    public int[] evenOddBit(int n) {
        int[] res=new int[2];
        int counto=0;
        int counte=0;
        String s=Integer.toBinaryString(n);
        int pos=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='1' && pos%2==0){
                counte++;
            }
            if(ch=='1' && pos%2!=0){
                counto++;
            }
            pos++;
        }
        res[0]=counte;
        res[1]=counto;
        return res;
    }
}