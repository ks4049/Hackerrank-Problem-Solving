import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int[] posAfterBribe = new int[q.length+1];
        int[] arrAfterBribe = new int[q.length];
        // Record the updated position after every bribe
        for(int i=0;i<q.length;i++){
            arrAfterBribe[i] = i+1;
            posAfterBribe[i+1] = i;
        } 
        int totalBribes=0,minBribes;
        for(int i=0;i<q.length;i++){
            if((posAfterBribe[q[i]])>i){
                minBribes=(posAfterBribe[q[i]]- i + q.length)% q.length;
                if(minBribes > 2){
                    totalBribes=-1;
                    break;
                }else{
                    totalBribes+= minBribes;
                }
            //Updating the positions  and array after bribe
              int  prevPos=posAfterBribe[q[i]];
                 for(int pp=posAfterBribe[q[i]]; pp>prevPos-minBribes; pp--){
                    int temp= arrAfterBribe[pp];
                    arrAfterBribe[pp] = arrAfterBribe[pp-1];
                    arrAfterBribe[pp-1]=temp;
                    int tempPos= posAfterBribe[arrAfterBribe[pp]];
                    posAfterBribe[arrAfterBribe[pp]] = posAfterBribe[arrAfterBribe[pp-1]];
                    posAfterBribe[arrAfterBribe[pp-1]]=tempPos;
                    }
            }
        }
        if(totalBribes == -1){
            System.out.println("Too chaotic");     
        }else{
            System.out.println(totalBribes);
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
