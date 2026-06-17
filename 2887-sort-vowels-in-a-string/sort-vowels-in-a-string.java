class Solution {
    public String sortVowels(String s) {
        List<Character> vowels=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if("aeiouAEIOU".indexOf(ch)!=-1){
                vowels.add(ch);
            }
        }
        Collections.sort(vowels);
        StringBuilder sb=new StringBuilder(s);
        int idx=0;
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                sb.setCharAt(i, vowels.get(idx++));
            }
        }
        return sb.toString();
    }
}