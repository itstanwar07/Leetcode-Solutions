class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        // Find the maximum number in nums to size our arrays
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Count frequencies of each number in nums
        long[] cnt = new long[maxVal + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        
        // countDivisor[d] stores the number of elements in nums that are multiples of d
        long[] countDivisor = new long[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            for (int v = d; v <= maxVal; v += d) {
                countDivisor[d] += cnt[v];
            }
        }
        
        // countGcdPair[g] will store the exact number of pairs having GCD == g
        long[] countGcdPair = new long[maxVal + 1];
        for (int d = maxVal; d >= 1; d--) {
            // Pairs where both elements are multiples of d
            countGcdPair[d] = countDivisor[d] * (countDivisor[d] - 1) / 2;
            
            // Subtract pairs whose exact GCD is a larger multiple of d
            for (int v = 2 * d; v <= maxVal; v += d) {
                countGcdPair[d] -= countGcdPair[v];
            }
        }
        
        // Convert to a prefix sum array: prefix[g] = pairs with GCD <= g
        long[] prefix = new long[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            prefix[d] = prefix[d - 1] + countGcdPair[d];
        }
        
        // Answer each query using binary search
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            
            int left = 1, right = maxVal;
            int res = maxVal;
            
            // Find the smallest g such that prefix[g] > q
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] > q) {
                    res = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = res;
        }
        
        return ans;
    }
}
