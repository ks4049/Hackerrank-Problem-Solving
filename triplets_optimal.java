import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static int[] sortArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[i]>arr[j]){
                    int temp =arr[i];
                    arr[i] = arr[j];
                    arr[j] = arr[i];
                }
            }
        }
        return arr;
    }
 
    static long triplets(int[] a, int[] b, int[] c) {
        long countTriplets=0,acnt=0,ccnt=0;
        //sorting A,B and C arrays
        a = sortArray(a);
        System.out.println("Sorted A");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        b = sortArray(b);
        c = sortArray(c);
         List listA = new ArrayList(a.length);
        List listB = new ArrayList(b.length);
        List listC = new ArrayList(c.length);
        for(int i=0;i<b.length;i++){
            if(!listB.contains(b[i])){
                listB.add(b[i]);
                acnt=0;ccnt=0;
                for(int j=0;j<a.length;j++){
                    if(!listA.contains(a[j]) && a[j] <= b[i]){
                        listA.add(a[j]);
                        acnt++;
                    }
                }listA.clear();
                for(int k=0;k<c.length;k++){
                    if(listC.contains(c[k]) && b[i]>=c[k]){
                        listC.add(c[k]);
                        ccnt++;
                    }
                }listC.clear();
                countTriplets+=acnt*ccnt;
                System.out.println("dfkjnknw"+ "   ac count"+acnt+ " "+ccnt+ " "+ countTriplets);
            }
        }
        return countTriplets;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
