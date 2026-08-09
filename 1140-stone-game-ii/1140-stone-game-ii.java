class Solution {
    Map<String, Integer> memo = new HashMap<>();
    int n;
    int[] piles;

    private int solve(int player, int i, int M) {
        if (i >= n) return 0;

        String key = player + "," + i + "," + M;
        if (memo.containsKey(key)) return memo.get(key);

        int stones = 0;
        int result = (player == 1) ? 0 : Integer.MAX_VALUE;

        for (int x = 1; x <= 2 * M; x++) {
            if (i + x > n) break;

            stones += piles[x + i - 1];
            if (player == 1) {
                result = Math.max(result, stones + solve(0, i + x, Math.max(M, x)));
            } else {
                result = Math.min(result, solve(1, i + x, Math.max(M, x)));
            }
        }

        memo.put(key, result);
        return result;
    }

    public int stoneGameII(int[] p) {
        piles = p;
        n = piles.length;
        return solve(1, 0, 1);
    }
}