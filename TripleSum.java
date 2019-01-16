import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static int findMax(int[] b){
        int max= b[0];
        for(int i=1;i<b.length;i++){
            if(b[i] > max){
                max= b[i];
            }
        }
        return max;
    }
    static int findMin(int[] c){
        int min=c[0];
        for(int i=1;i<c.length;i++){
            if(c[i]<min){
                min = c[i];
            }
        }
        return min;
    }
    static long triplets(int[] a, int[] b, int[] c) {
        long countTriplets=0;
        int maxB = findMax(b); // to compare elements of A with max(B array)
        int minC = findMin(c); // to compare elements of B with min(C array)
        System.out.println("Max of b  "+maxB + "   ----"+"Max of C  "+minC);
        List listA = new ArrayList(a.length);
        List listB = new ArrayList(b.length);
        List listC = new ArrayList(c.length);
        for(int i=0;i<a.length;i++){
            if(!listA.contains(a[i]) && a[i]<=maxB){
                System.out.println("Hello1" + " "+ a[i]);
                listA.add(a[i]);
                for(int j=0;j<b.length;j++){
                    if((a[i] <= b[j]) && !listB.contains(b[j]) && b[j]>=minC){
                        System.out.println("Hello2" + " "+ b[j]);
                        listB.add(b[j]);
                        for(int k=0;k<c.length;k++){
                            if(b[j] >= c[k] && (!listC.contains(c[k]))){
                                System.out.println("Hello3"+ " "+ c[k]);
                                listC.add(c[k]);
                                countTriplets++;
                            }
                        }listC.clear();
                    }
                } listB.clear();
            }
        } 
        System.out.println("List A "+listA+"   listB "+ listB+"   listC  "+listC  +"count triplets"  + countTriplets);
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
