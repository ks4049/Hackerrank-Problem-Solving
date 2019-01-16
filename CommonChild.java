import java.io.*;
import java.util.*;
public class CommonChild{
	public static void main(String[] args){

		//get the two strings
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		// store the matching positions in the hash map
		HashMap<Integer,List<Integer>> positionMap = new HashMap<Integer, List<Integer>>();
		char[] str1Char = str1.toCharArray();
		char[] str2Char = str2.toCharArray(); 
		for(int i=0; i<str1Char.length; i++){
			for(int j=0 ; j<str2Char.length; j++){
				if(str1Char[i] == str2Char[j]){
					if(!positionMap.containsKey(i)){
						positionMap.put(i,new ArrayList<Integer>());
					}
					positionMap.get(i).add(j);
				}
			}
		}
		System.out.println("The matching positions are ===="+ positionMap);
		int maxLength =0, len=0;
		for(int i=0; i<str1Char.length-1; i++){
			if(positionMap.containsKey(i) && (str1Char.length-i) > maxLength){
				int match = positionMap.get(i).get(0);
				len=1;
				for(int j=i+1; j<str1Char.length; j++){
					if(positionMap.containsKey(j)){
						List<Integer> tempList = positionMap.get(j);
						for(int l=0; l<tempList.size(); l++){
							if(match < tempList.get(l)){
								len++;
								match = tempList.get(l);
								break;
							}	
						}		
					}
				} 
				if(maxLength < len){
					maxLength = len;
				}
				System.out.println("maxlength.  "+maxLength);
			}
			
		}
		System.out.println("The length of the common child is "+ maxLength) ;

	}
}