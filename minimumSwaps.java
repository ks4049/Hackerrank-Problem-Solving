import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static long minimumSwaps(long[] arr) {
        long temp,diff,highDiff,noOfSwaps=0;
        int swpIdx;
        for(int i=0;i<arr.length-1;i++){
            swpIdx=i;highDiff=0;
            for(int j=arr.length-1;j>i;j--){
                if(arr[i] == i+1){
                    break;
                }
                if(arr[j] == j+1){
                    continue;
                }
                if(arr[i] > arr[j]){
                    diff=arr[i]- arr[j];
                    if(diff > highDiff){
                        highDiff = diff;
                        swpIdx = j;
                    }
                }
                if((swpIdx != i) && (arr[swpIdx] == (i+1))){
                    temp=arr[i];
                    arr[i]=arr[swpIdx];
                    arr[swpIdx]=temp;
                    noOfSwaps++;
                    break;
                } 
            }
            //swap the values     
        }
        System.out.println("Minimum Swaps: "+noOfSwaps);
        return noOfSwaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[(int)n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

