class Solution {
    public int maxProduct(int[] nums) {
        int l= nums.length;
        Arrays.sort(nums);
        int max =nums[l-1];
        int min=nums[l-2];
        return (max-1)*(min-1);
    }
}