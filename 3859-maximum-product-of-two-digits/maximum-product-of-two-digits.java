class Solution {
    public int maxProduct(int n) {
        int count=0;
        int temp=n;
        while(temp>0){
            int digit=temp%10;
            count++;
            temp/=10;
        }
        int[] arr=new int[count];
        int i=0;
        while(n>0){
            int rem=n%10;
            arr[i++]=rem;
            n/=10;
        }
        int l=arr.length;
        int max1=Integer.MIN_VALUE;
        for(int k=0;k<l;k++){
            int prod=1;
            for(int j=k+1;j<l;j++){
                prod=arr[k]*arr[j];
                max1=Math.max(max1,prod);
            }
        }
        return max1;
    }
}