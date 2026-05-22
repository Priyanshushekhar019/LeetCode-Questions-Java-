class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(k == 1) {
            return r - l + 1;
        }

        int count=0;
        for(int i = 0; ; i++) {

            long val = (long)Math.pow(i, k);

            if(val > r) {
                break;
            }

            if(val >= l && val <= r) {
                count++;
            }
        }
        return count;
    }
}