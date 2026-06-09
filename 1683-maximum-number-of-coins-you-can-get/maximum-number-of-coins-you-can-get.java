class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum=0;
        int left=0;
        int right=piles.length-2;
        while(left<right){
            sum+=piles[right];
            right-=2;
            left++;
        }
        return sum;
    }
}