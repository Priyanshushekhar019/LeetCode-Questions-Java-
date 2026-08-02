class Solution {
    public static boolean palindrome(String str){
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            if(palindrome(words[i])){
                return words[i];
                // break;
            }
        }
        return "";
    }
}