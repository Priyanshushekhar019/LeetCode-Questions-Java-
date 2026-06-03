import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int ans1 = solve(landStartTime, landDuration,
                         waterStartTime, waterDuration);

        int ans2 = solve(waterStartTime, waterDuration,
                         landStartTime, landDuration);

        return Math.min(ans1, ans2);
    }

    private int solve(int[] firstStart, int[] firstDur,
                      int[] secondStart, int[] secondDur) {

        int n = firstStart.length;
        int m = secondStart.length;

        int[] finishTimes = new int[n];

        for (int i = 0; i < n; i++) {
            finishTimes[i] = firstStart[i] + firstDur[i];
        }

        Arrays.sort(finishTimes);

        int[][] rides = new int[m][2];

        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));

        int[] suffixMin = new int[m];

        suffixMin[m - 1] = rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(
                    suffixMin[i + 1],
                    rides[i][0] + rides[i][1]
            );
        }

        int ans = Integer.MAX_VALUE;

        int j = 0;
        int minDuration = Integer.MAX_VALUE;

        for (int t : finishTimes) {

            while (j < m && rides[j][0] <= t) {
                minDuration = Math.min(minDuration, rides[j][1]);
                j++;
            }

            if (minDuration != Integer.MAX_VALUE) {
                ans = Math.min(ans, t + minDuration);
            }

            if (j < m) {
                ans = Math.min(ans, suffixMin[j]);
            }
        }

        return ans;
    }
}