class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int sum=0;
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>map:mp.entrySet()){
            if(map.getValue()%k==0){
                sum=sum+map.getValue()*map.getKey();
            }
        }
        return sum;
    }
}