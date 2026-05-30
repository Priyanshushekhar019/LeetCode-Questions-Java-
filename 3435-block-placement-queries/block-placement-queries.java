import java.util.*;

class Solution {
    static class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }

            int mid = (l + r) / 2;

            if (idx <= mid) {
                update(node * 2, l, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, val);
            }

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int ql, int qr) {
            if (ql > qr) return 0;
            return query(1, 0, n - 1, ql, qr);
        }

        int query(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return 0;
            if (ql <= l && r <= qr) return tree[node];

            int mid = (l + r) / 2;

            return Math.max(
                query(node * 2, l, mid, ql, qr),
                query(node * 2 + 1, mid + 1, r, ql, qr)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int[] q : queries) {
            if (q[0] == 1) {
                set.add(q[1]);
            }
        }

        List<Integer> coords = new ArrayList<>(set);

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < coords.size(); i++) {
            idxMap.put(coords.get(i), i);
        }

        SegmentTree seg = new SegmentTree(coords.size());

        for (int i = 1; i < coords.size(); i++) {
            seg.update(i, coords.get(i) - coords.get(i - 1));
        }

        List<Boolean> ans = new ArrayList<>();

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] q = queries[i];

            if (q[0] == 1) {
                int x = q[1];

                Integer left = set.lower(x);
                Integer right = set.higher(x);

                set.remove(x);

                if (right != null && left != null) {
                    seg.update(idxMap.get(right), right - left);
                }

            } else {
                int x = q[1];
                int sz = q[2];

                Integer prev = set.floor(x);

                int best = 0;

                if (prev != null) {
                    int idx = idxMap.get(prev);
                    best = Math.max(best, seg.query(0, idx));
                    best = Math.max(best, x - prev);
                }

                ans.add(best >= sz);
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}