// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashSet<Character> set=new HashSet<>();
//         for(int i =0;i<s.length();i++){
//             char ch=s.charAt(i);
//             set.add(ch);
//         }
//         return set.size();
//     }
// }
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}