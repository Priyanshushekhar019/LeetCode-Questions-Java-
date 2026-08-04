import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Set<Integer> set1=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set1.add(nums[i]);
        }
        int min1=Integer.MAX_VALUE;
        int max2=Integer.MIN_VALUE;
        for(int num2:nums){
            min1=Math.min(min1,num2);
            max2=Math.max(max2,num2);
        }
        
        for(int i=min1;i<=max2;i++){
            if(!set1.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}