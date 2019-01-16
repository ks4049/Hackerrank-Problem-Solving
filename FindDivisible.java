import java.io.*;
import java.util.*;

public class FindDivisible{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int[][] lr = new int[testCases][2];
		for(int i=0; i<testCases; i++){
			// get the ranage limits
			 lr[i][0] = sc.nextInt();
			 lr[i][1] = sc.nextInt();
		}
		//logic to find the pair
		for(int i=0; i<testCases; i++){
			if(lr[i][0]==1){
				System.out.println(lr[i][0]+ " "+lr[i][1]);
			}else{
				int l = lr[i][0];
				int r = lr[i][1];
				while(r%l !=0){
					int m= r%l;
					r-=m;
					if(r<=l){
						//retain the r value 
						r = lr[i][1];
						l++;
						r--;
					}
				}
				System.out.println(l+" "+r);
			}
		}
	}
}