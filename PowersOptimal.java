import java.io.*;
import java.util.*;
public class PowersOptimal{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int k=0,i=0;
		int sum = sc.nextInt();
		int powlen = sc.nextInt();
		int[] result = new int[powlen];

		if(powlen ==1){
			if((sum&(sum-1))==0){
				System.out.println("YES");
				System.out.println(sum);
			}else{
				System.out.println("NO");
			}
		}else if (powlen == sum || sum%powlen==0){
			System.out.println("YES");
			for(int p=0;p<powlen;p++){
				System.out.print("1 ");
			}
			if(sum > powlen){
				int rem = sum -powlen;
				for(int p=0;p<rem/2;p++){
					System.out.print("2 ");
				}
			}
		} else{
			String bits = Integer.toBinaryString(sum);
			char[] bitArray = bits.toCharArray();			
			for(i=bitArray.length-1; i>=0; i--){
				if(k==powlen){
					break;
				}
				if(bitArray[i]=='1'){
					result[k++] = 1 << (bitArray.length-i-1);
				}
			}
			if(powlen == k && i==-1 ){
				// print the array
				System.out.println("YES");
				for(int j=0;j<powlen;j++){
					System.out.print(result[j]+" ");
				}
			}else if(k<powlen){
				// 
				int tempSum =0;
				for(int m=0,l=0;m<powlen; m++){
					if(tempSum < sum){
						k=m; 
						int rem = sum - tempSum;
						if(rem >= (int)Math.pow(2,l)){
							result[m] = (int)Math.pow(2,l);
						 	tempSum+= result[m];
						 	l++;
						}else{
							//decrement l until reminder equals some power of 2
							while(rem < (int)Math.pow(2,l)){
								l--;
							}
							result[m] = (int)Math.pow(2,l);
							tempSum+=result[m];
						}
					}
					
				}
				if(tempSum == sum && k==powlen-1){
					PowersOptimal.printArrayElements(result);
				}else{
					System.out.println("NO");
				}
			}
			else{
				System.out.println("NO");
			}
		}
	}
	public static void printArrayElements(int[] array){
		//sort the elements in the array
		for(int i=0; i< array.length-1;i++){
			for(int j=i+1; j< array.length; j++){
				if(array[i] > array[j]){
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println("YES");
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
}
