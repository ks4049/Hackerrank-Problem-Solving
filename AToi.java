import java.io.*;
import java.util.*;

class AToi {
    public static int myAtoi(String str)throws IOException {
        int t=0,sum=0,prevSum=0,m=10;
        boolean isPositive = true;
        if(str.trim().length() > 0){
             char[] nums = str.trim().toCharArray();
            if(nums[0]=='-'){
                isPositive = false;
                t=1;
            }else if(nums[0]=='+'){
                t=1;
            }
            if( t== nums.length || nums[t]< 48 || nums[t]>57){
                return 0;
            }
            for(int i=t;i<nums.length;i++){
                if(nums[i] >=48 && nums[i]<=57){
                     int temp = (int)nums[i]-48;
                     prevSum = sum;
                     sum=(sum*m) + temp;  
                    if(!isPositive && (prevSum!=(sum-(sum%10))/m)){
                        return Integer.MIN_VALUE;
                    }else if (isPositive && (prevSum!=(sum-(sum%10))/m)){
                        return Integer.MAX_VALUE;
                    }
                }else{
                    break;
                }
            }   
        }   
        if(isPositive){
            return sum;
        }else{
            return (0-sum);
        }       
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int number = myAtoi(str);
        System.out.println(number);
    }
}