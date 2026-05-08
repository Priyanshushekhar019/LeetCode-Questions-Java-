class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        if(n <= 1) {
            return 0;
        }

        int max = 0;

        for(int x : nums) {
            max = Math.max(max, x);
        }

        // store indices divisible by value
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {

            for(int d = 1; d * d <= nums[i]; d++) {

                if(nums[i] % d == 0) {

                    map.computeIfAbsent(d, k -> new ArrayList<>()).add(i);

                    if(d != nums[i] / d) {
                        map.computeIfAbsent(nums[i] / d,
                                k -> new ArrayList<>()).add(i);
                    }
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int jump = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            while(size-- > 0) {

                int i = q.poll();

                if(i == n - 1) {
                    return jump;
                }

                // left
                if(i - 1 >= 0 && !vis[i - 1]) {
                    vis[i - 1] = true;
                    q.offer(i - 1);
                }

                // right
                if(i + 1 < n && !vis[i + 1]) {
                    vis[i + 1] = true;
                    q.offer(i + 1);
                }

                // teleport
                if(prime(nums[i]) && map.containsKey(nums[i])) {

                    for(int next : map.get(nums[i])) {

                        if(!vis[next]) {
                            vis[next] = true;
                            q.offer(next);
                        }
                    }

                    // important to avoid TLE
                    map.remove(nums[i]);
                }
            }

            jump++;
        }

        return -1;
    }

    public boolean prime(int n) {

        if(n <= 1) {
            return false;
        }

        for(int i = 2; i * i <= n; i++) {

            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}