import java.io.*;
import java.util.*;
public class PowersTwo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int tempSum =0,last=0;
		int sum = sc.nextInt();
		int powlen = sc.nextInt();
		int[] arr = new int[powlen];
		for(int i=0,k=0;i<powlen; i++){
			last=i;
			if(powlen == 1 && isPowerOfTwo(sum)){
				System.out.println("YES"+"\n"+sum);
				return;
			}else if(tempSum < sum){
				int rem = sum - tempSum;
				if(rem >= (int)Math.pow(2,k)){
					arr[i] = (int)Math.pow(2,k);
				 	tempSum+= arr[i];
				 	k++;
				}else{
					//decrement k until reminder equals some power of 2
					while(rem < (int)Math.pow(2,k)){
						k--;
					}
					arr[i] = (int)Math.pow(2,k);
					tempSum+=arr[i];
				}
			}
			if(arr[i]==0){
				break;
			}
			System.out.println("arr=="+arr[i]);
		}
		if(tempSum == sum && last==powlen-1){
			PowersTwo.printArrayElements(arr);
		}else{
			System.out.println("NO");
		}
	}

	public static  boolean isPowerOfTwo(int num){
		return (num & (num-1))==0;
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