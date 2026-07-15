class Solution { 
    public int findMaxConsecutiveOnes(int[] nums) { 
        int currentStreak = 0; 
        int maxStreak = 0; 
        
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] == 1) { 
                currentStreak++; 
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else { 
                currentStreak = 0; 
            } 
        } 
        return maxStreak; 
    } 
}