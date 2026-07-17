class Solution {
    public int maxDigitRange(int[] nums) {
        int n=nums.length;
        int[] range=new int[n];
        int maxRange=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int maxDigit=0;
            int minDigit=9;
            while(num>0){
                int digit=num%10;
                if(digit>maxDigit){
                    maxDigit=digit;
                }
                if(digit<minDigit){
                    minDigit=digit;
                }
                num/=10;
            }
            range[i]=maxDigit-minDigit;
            if(range[i]>maxRange){
                maxRange=range[i];
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            if(range[i]==maxRange){
                sum+=nums[i];
            }
        }
        return sum;
    }
}