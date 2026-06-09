class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long gmax=Long.MIN_VALUE;
        long smin=Long.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            gmax=Math.max(gmax,(long)nums[i]);
            smin=Math.min(smin,(long)nums[i]);
        }
        long value=gmax-smin;
        return value*k;
            
        
    }
}