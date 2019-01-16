import java.util.*;
import java.io.*;

public class LicenseCode{
	public static void main(String[] args)throws IOException{
		//get the input using Buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		int noOfDashes=0, j=0;
		int k = Integer.parseInt(br.readLine());
		char[] codeArray = code.toCharArray();
		char[] resultCode  = new char[2*k*codeArray.length];
		//converting small to caps in the license code
		for(int i=codeArray.length-1; i>=0; i--){
			System.out.println("ca"+codeArray[i]);
			if(codeArray[i]=='-'){
				continue;
			}else if(codeArray[i] >=97 && codeArray[i]<=123){
				resultCode[j++]= Character.toUpperCase(codeArray[i]);
			}else{
				resultCode[j++] = codeArray[i];
			}
			System.out.println("----"+resultCode[j-1]);
			if(((j-noOfDashes) % k ==0 )&& (i > 0)){
				resultCode[j++]='-';
				noOfDashes++;
			}
			System.out.println("----"+resultCode[j-1]+" -=i"+i);
		}
		int t=j-1;
		if(resultCode[j-1]=='-'){
			t=j-2;
		}
		char[] reverseCode = new char[t+1];
        for(int i=0,m=t; m>=0; m--,i++){
            reverseCode[i]= resultCode[m];
        }
		System.out.println("The proper license code is "+ new String(reverseCode));	
        
	}
}