class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res=new int[2];
        int i=0;
        int j=numbers.length-1;
        int k=0;
        while(i<j){
            int sum=numbers[i]+numbers[j];
            if(sum==target){
                res[k++]=i+1;
                res[k++]=j+1;
                break;
            }
            else if(sum>target){
                j=j-1;
            }
            else{
                i=i+1;
            }
        }
        return res;
    }
}