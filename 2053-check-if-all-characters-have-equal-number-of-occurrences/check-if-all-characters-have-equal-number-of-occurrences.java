class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int first = mp.entrySet().iterator().next().getValue();
        for(Map.Entry<Character,Integer>map:mp.entrySet()){
            if(map.getValue()!=first){
                return false;
            }
        }
        return true;
    }
}