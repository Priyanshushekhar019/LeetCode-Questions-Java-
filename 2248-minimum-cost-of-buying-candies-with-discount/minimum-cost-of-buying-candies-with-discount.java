class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum=0;
        int count=1;
        for(int i=cost.length-1;i>=0;i--){
            if(count%3!=0){
                sum+=cost[i];
            }
            count++;
        }
        return sum;
    }
}