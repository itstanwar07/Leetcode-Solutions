class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int n = nums.length;
        
        // Loop through the 0-indexed array
        for (int i = 0; i < n; i++) {
            // Convert to 1-indexed by checking (i + 1)
            if (n % (i + 1) == 0) {
                sum += nums[i] * nums[i]; 
            }
        }
        
        return sum;
    }
}
