class Solution {
    public String removeOuterParentheses(String s) {
         StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If this '(' is NOT the outermost, keep it
                if (depth > 0) {
                    result.append(c);
                }
                depth++;
            } else {
                depth--;
                // If this ')' is NOT the outermost, keep it
                if (depth > 0) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}