
import java.util.Arrays;


class Merrged_Array {
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
     {
        int n=nums1.length;
        int m=nums2.length;
        int [] mrgarr= new int[n+m];
        for(int i=0;i<n;i++)
        {
            mrgarr[i]=nums1[i];
        }  
        for(int i=0;i<m;i++)
        {
            mrgarr[i+n]=nums2[i];

        } 
        Arrays.sort(mrgarr);
        int total =n+m;
        if(total%2==1)
        {
            return (double) mrgarr[total/2];

        }   
        else
        {
            int mid1=mrgarr[total/2 - 1];
            int mid2=mrgarr[total/2];
            return (mid1+mid2)/2.0;
        } 
    }
}