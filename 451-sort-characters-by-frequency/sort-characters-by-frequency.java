// class Solution {
//     public String frequencySort(String s) {
//         char[] arr=s.toCharArray();
//         Arrays.sort(arr);
//         String sort=new String(arr);
//         return sort;
//     }
// }
import java.util.*;

class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Convert to character array
        Character[] arr = new Character[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        // Sort by frequency descending
        Arrays.sort(arr, (a, b) -> {
            int freqCompare = map.get(b) - map.get(a);

            if (freqCompare == 0) {
                return a - b; // uppercase and lowercase remain different
            }

            return freqCompare;
        });

        StringBuilder sb = new StringBuilder();

        for (char ch : arr) {
            sb.append(ch);
        }

        return sb.toString();
    }
}