// class Solution {
//     public char processStr(String s, long k) {
//         StringBuilder sb=new StringBuilder();
//         for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             if(ch>='a' && ch<='z'){
//                 sb.append(ch);
//             }
//             else if(ch=='*'){
//                 if(sb.length()>0){
//                     sb.deleteCharAt(sb.length()-1);
//                 }
//             }
//             else if(ch=='#'){
//                 sb.append(sb.toString());
//             }
//             else if(ch=='%'){
//                 sb.reverse();
//             }
//         }
//         String str=sb.toString();
//         if(k<0 || k>=str.length()){
//             return '.';
//         }
//         return str.charAt((int)k);
//     }
// }
class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                len++;
            } else if (c == '*') {
                len = Math.max(0, len - 1);
            } else if (c == '#') {
                len *= 2;
            }
        }

        if (k >= len) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                len--;
                if (k == len) return c;
            }
            else if (c == '*') {
                len++;
            }
            else if (c == '#') {
                len /= 2;
                if (k >= len) {
                    k -= len;
                }
            }
            else if (c == '%') {
                k = len - 1 - k;
            }
        }

        return '.';
    }
}