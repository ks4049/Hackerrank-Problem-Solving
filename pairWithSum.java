import java.io.*;
import java.util.*;

public class pairWithSum{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int flag=0;
		int n = sc.nextInt();
		int[] input = new int[n];
		for(int i=0; i<n; i++){
			input[i] = sc.nextInt();			
		}
		int sum = sc.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++){
			if(set.contains(sum-input[i])){
				flag=1;
				break;
			}else{
				set.add(sum-input[i]);
			}
		}
		if(flag ==1){
			System.out.println("Found the pair");
		}else{
			System.out.println("Not found");
		}
	}
}