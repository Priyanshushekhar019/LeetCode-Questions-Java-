class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int a=nums[n-1];
        int b=nums[n-2];
        int prod=(a-1)*(b-1);
        return prod;
    }
}