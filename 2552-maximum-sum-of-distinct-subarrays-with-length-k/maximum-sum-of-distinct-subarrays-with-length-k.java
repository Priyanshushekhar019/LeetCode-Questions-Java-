class Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        long sum = 0;
        long max = 0;

        int[] freq = new int[100001];

        int left = 0;
        int distinct = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add nums[right]
            sum += nums[right];

            if (freq[nums[right]] == 0) {
                distinct++;
            }

            freq[nums[right]]++;

            // Window size > k
            if (right - left + 1 > k) {

                sum -= nums[left];

                freq[nums[left]]--;

                if (freq[nums[left]] == 0) {
                    distinct--;
                }

                left++;
            }

            // Valid window
            if (right - left + 1 == k && distinct == k) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}