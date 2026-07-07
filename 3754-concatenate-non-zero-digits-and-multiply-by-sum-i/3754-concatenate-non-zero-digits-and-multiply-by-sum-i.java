class Solution {
    public long sumAndMultiply(int n) {
        long result = 0;
        int sum=0;
        long concat=1;
        long placevalue=1;
        while(n>0){
            int digit = n%10;

            if(digit!=0){
                result = result +( digit * placevalue );
                placevalue*=10;
                sum=sum + digit;
            }
            n=n/10;
        }
        concat = result*sum;
        return concat;
    }
}