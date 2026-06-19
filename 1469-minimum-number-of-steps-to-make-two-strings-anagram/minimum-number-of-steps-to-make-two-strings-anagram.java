class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer>mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        HashMap<Character,Integer>mp2=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)-1);
        }
        int ans=0;
          for (int val : mp.values()) {
            if (val > 0) {
                ans += val;
            }
        }

        return ans;
    }
}