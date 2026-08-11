class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // we have array of candies and we have extra candies which we have to add in each of the n kid and here n is the number of kid and is the length of the array
        List<Boolean> result = new ArrayList<>();

        // checking for the maxcandies
        int maxcandies = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if(candies[i]>maxcandies) maxcandies=candies[i];
        }

//        checking number of candles for each kid in this only checking for extracandies too

        for (int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= maxcandies) result.add(true);
            else result.add(false);
        }
        return result;
    }
}