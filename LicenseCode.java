import java.util.*;
import java.io.*;

class LicenseCode {
    public String licenseKeyFormatting(String S, int K) {
        int noOfDashes=0, j=0;
		char[] codeArray = S.toCharArray();
        StringBuilder sb = new StringBuilder();
		//converting small to caps in the license code
		for(int i=codeArray.length-1; i>=0; i--){
			if(codeArray[i]=='-'){
				continue;
			}else if(codeArray[i] >=97 && codeArray[i]<=123){
				 sb.append(Character.toUpperCase(codeArray[i]));
			}else{
				sb.append(codeArray[i]);
			}
			if(((sb.length()-noOfDashes) % K ==0 )&& (i > 0)){
				sb.append('-');
				noOfDashes++;
			}
		}
        if(sb.length() > 0 && sb.charAt(sb.length()-1) == '-'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String S = br.readLine();
    	int K = Integer.parseInt(br.readLine());
    	String result = licenseKeyFormatting(S,K);
    	System.out.println(result);
    }
}