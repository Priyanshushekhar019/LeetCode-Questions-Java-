class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int farthest = 0;

        while (!q.isEmpty()) {
            int i = q.poll();

            if (i == n - 1) {
                return true;
            }

            int start = Math.max(i + minJump, farthest);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    q.offer(j);
                }
            }

            farthest = end + 1;
        }

        return false;
    }
}