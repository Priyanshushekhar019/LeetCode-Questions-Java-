class Solution {
    public int[] searchRange(int[] nums, int target) {
        ArrayList<Integer>ar=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                ar.add(i);
            }
        }
        int[] arr=new int[2];
        Arrays.fill(arr,-1);
        if(ar.size()>0){
            arr[0]=ar.get(0);
            arr[1]=ar.get(ar.size()-1);
        }
        return arr;
    }
}