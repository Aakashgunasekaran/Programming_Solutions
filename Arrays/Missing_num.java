public class Missing_num 
{
    
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        int total = n*(n+1)/2;
        for(int num:nums)
        {
            sum+=num;
        }
        return total-sum;

        
    
    }
}
