import java.io.*;
import java.util.*;

class Solution {
    public int leastOpsExpressTarget(int x, int target) {
       
        int mulOp=0, addOp=0, remOp=0,stRemOp=0,flag=1;
        int minOps=0, sumOps=0,temp=target,stTemp=target, x1=x, xCnt=1;
        while(flag==1){
            System.out.println("temp and x1 "+temp+" "+x1);
            remOp=0;
            int rem = temp % x1;
             int amt = x1-rem;
            //  if(rem!=0){
            //     if(rem>x||amt>x){
            //         int remCnt = leastOpsExpressTarget(x,amt);
            //         int amtCnt = leastOpsExpressTarget(x, rem);
            //         if(remCnt < amtCnt){
            //             remOp = remCnt;
            //             temp-=rem;
            //         }else{
            //             remOp = amtCnt;
            //             temp+=amt;
            //         }
            //     }else if(amt ==x || rem ==x){
            //         remOp = 1;
            //     }else if(amt < rem){
            //         remOp=amt*2;
            //     }else{
            //         remOp = rem*2;
            //     }
            // }
            if((rem>amt&&((x1==x)||(rem-amt)>x)) || (temp < x1)){
                //add the amount to temp and reduce by the same amount
               
                temp+=amt;
                if(amt > x){
                    // find the least number of ops to form the reminder number
                    remOp= leastOpsExpressTarget(x, amt)+1; // plus one for subtract operation
                }else if(amt == x){
                    remOp=1; // to subtract the amount
                }else{
                    remOp= amt*2; // one minus and followed by / for amt times
                }
            }else if(rem!=0){
                // add the remainder amount and reduce the temp by remainder
                temp-=rem;
                if(rem > x){
                    remOp= leastOpsExpressTarget(x, rem)+1; // plus one to add the rem
                }else if(rem == x){
                    remOp=1;
                }else{
                    remOp=rem*2;
                }
            }
            if(x1==x){
                stRemOp = remOp;
                stTemp = temp;
            }
            System.out.println("temp and x1 "+temp+" "+x1);

            //now temp will be divisible by x1
            int q = temp/x1; //quotient
            addOp = q-1;
            mulOp = q*(xCnt-1);
            sumOps = addOp+mulOp+stRemOp;
            if(x1!=x){
                sumOps+=remOp;
            }
            System.out.println(sumOps);
            if(sumOps < minOps || minOps==0){
                minOps = sumOps;
                if(2*temp > x1*x){
                    x1*=x; // increase x1 by x times to get a even smaller noOfOps
                    xCnt++;
                    temp = stTemp;
                }else
                {
                    flag=0;
                }
            }else{
                flag=0;
            }
        }
         return minOps;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int x = sc.nextInt();
        Solution soln = new Solution();
        int result = soln.leastOpsExpressTarget(x, target);
        System.out.println("The minimum number of operations "+result);
    }
}