import java.util.Arrays;
class Solution 
{ 
    //Nabamita
    private int gcd(int a , int b )
    {
        while ( b != 0 )
        {
          int temp = b;
          b = a % b;
          a = temp;
        }
    
     return a ;
    }
    


    public long gcdSum(int[] nums) 
    {
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int currentmax = 0;

        for ( int i = 0; i < n ; i++)
        {
            currentmax = Math.max( currentmax , nums[i]);

            prefixGcd[i] = gcd( nums[i], currentmax);

        }
        Arrays.sort(prefixGcd);
        long sum = 0;
       
        int left = 0;
        int right = n-1;

        while (left < right)
        {
            sum += gcd( prefixGcd[left], prefixGcd[right] );
            left++;
            right--;
        }
        return sum;

    }
}