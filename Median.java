import java.io.*;
import java.util.*;

class Median {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int[] mergeArr = new int[nums1.length+nums2.length];
        int k=0,i,j;
        for(i=0,j=0; i<nums1.length && j< nums2.length;){
           if(nums1[i] < nums2[j]){
               mergeArr[k++] = nums1[i++];
           }else{
               mergeArr[k++] = nums2[j++];
           }
        }
        while(i < nums1.length){
            mergeArr[k++] = nums1[i++];
        }
        while(j < nums2.length){
            mergeArr[k++] = nums2[j++];
        }
        if(mergeArr.length %2 !=0){
            return mergeArr[mergeArr.length/2];
        }else{
            return (float)(mergeArr[mergeArr.length/2]+ mergeArr[(mergeArr.length/2)-1])/2;
        }
    }
// worst case possible
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt();
        int len2 = sc.nextInt();
        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];
        //Get the sorted integer arrays
        for(int i=0;i<len1;i++){
            nums1[i] = sc.nextInt();
        }
        for(int i=0;i<len2;i++){
            nums2[i] = sc.nextInt();
        }
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}