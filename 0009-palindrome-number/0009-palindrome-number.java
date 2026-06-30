class Solution {
    public boolean isPalindrome(int x) { 
        if(x<0)
        return false;

        int orignumber=x;
        int revnumber=0;
        while(x>0)
        {
            int lastdigit=x%10;
            revnumber=(revnumber *10)+lastdigit;
            x/=10;
        }
        return orignumber==revnumber;
    }
}