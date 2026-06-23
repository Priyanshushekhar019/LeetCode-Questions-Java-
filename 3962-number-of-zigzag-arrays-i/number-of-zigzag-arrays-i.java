class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2 initialization
        for (int v = 0; v < m; v++) {
            up[v] = v;               // values smaller than v
            down[v] = m - 1 - v;     // values greater than v
        }

        // Build lengths 3..n
        for (int len = 3; len <= n; len++) {
            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefUp[i + 1] = (prefUp[i] + up[i]) % MOD;
                prefDown[i + 1] = (prefDown[i] + down[i]) % MOD;
            }

            long totalUp = prefUp[m];
            long totalDown = prefDown[m];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int v = 0; v < m; v++) {
                // previous move must be down, and previous value < v
                newUp[v] = prefDown[v];

                // previous move must be up, and previous value > v
                newDown[v] = (totalUp - prefUp[v + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans = (ans + up[i] + down[i]) % MOD;
        }

        return (int) ans;
    }
}