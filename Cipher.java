import java.io.*;
import java.util.*;
public class Cipher{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int textLength = sc.nextInt();
		//Scanner sc1 = new Scanner(System.in);
		String encryptedText = sc.next();
		char[] encryptedChar = encryptedText.toCharArray();
		int originalLen=0;
		if(textLength ==1){
			originalLen = textLength;
		}else{
			int temp = textLength*2;
			//find n 
			int i=2;
			while(i< temp/2){
				if((i*(i+1))==temp){
					originalLen = i;
					break;
				}else{
					i++;
				}
			}
		}
		char[] originalText = new char[originalLen];
		for(int i=0, j=0; i < encryptedChar.length && j < originalLen ; j++){
			originalText[j] = encryptedChar[i];
			i = ((j+1)*(j+2))/2;
		}
		System.out.println(new String(originalText));
	}
}
