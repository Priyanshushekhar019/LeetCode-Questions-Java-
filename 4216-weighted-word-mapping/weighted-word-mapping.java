class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res=new StringBuilder();
        for(String word:words){
            int total=0;
            for(char ch:word.toCharArray()){
                total=total+weights[ch-'a'];
            }
            int val=total%26;
            char mapping=(char)('z'-val);
            res.append(mapping);
        }
        return res.toString();
    }
}