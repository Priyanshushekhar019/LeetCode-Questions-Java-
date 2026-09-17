class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[]=new int[nums.length];
        //         for(int i=0;i<nums.length;i++){
        //     int product=1;
        //     for(int j=0;j<nums.length;j++){
        //         if(i==j){
        //             continue;
        //         }
        //         product*=nums[j];
        //     }
        //     result[i]=product;
        // }
        // return result;
        //2nd method
         result[0]=1;
        for(int i=1;i<nums.length;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        int suffix=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]*=suffix;
            suffix*=nums[i];
        }
        return result;
        //3rd method
        // int prod=1;
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     prod*=nums[i];
        // }
        // for(int i=0;i<n;i++){
        //     result[i]=prod/nums[i];
        // }
        // return result;
    }
}