import java.util.*;
class Two_sum {
    public int[] twoSum(int[] nums, int target) 
    {
        //Greedy approach
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // value
            arr[i][1] = i;       // index
        }

        // Step 2: sort by value
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int left = 0, right = n - 1;

        while(left<right)
        {
            int sum = arr[left][0] + arr[right][0];
            if(sum == target)
            {
              return new int[]{arr[left][1], arr[right][1]};
             }
             else if(sum<target)
             {
                left++;
             }
             else
             {
                right--;
             }
           
            
        }
      return new int[]{-1, -1}; 
    }
}