 /*
  Add two numbers, where the digits of the two numbers are provided in the form of linked list in the reverse order.
  */
import java.io.*;
import java.util.*;

class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;
        int carryOn = 0;
        int tempSum =0;
        // Traversing through the lists to add every digit
        while(l1!= null || l2!=null){
            int x = (l1==null)? 0:l1.val;
            int y = (l2==null)? 0:l2.val;
             tempSum = x+y+ carryOn;
            ListNode temp = new ListNode(tempSum%10);
            if(head == null){
                head = last = temp;
            }else{
                last.next = temp;
                last = temp;
            }
            carryOn = tempSum/10;
            l1= (l1==null)? null : l1.next;
            l2= (l2==null)? null : l2.next;
        }
       
        if(carryOn !=0){
            ListNode t = new ListNode(carryOn);
            last.next = t;
            t = last;
        }
        return head;
    }
    //Displaying the linked list contents
    public static void display(ListNode list){
        ListNode temp= list;
        while(temp!= null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    // get the two input arrays and form the two linked list
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int list1Len = Integer.parseInt(br.readLine());
        int list2Len = Integer.parseInt(br.readLine());
        int[] list1Arr = new int[list1Len];
        int[] list2Arr = new int[list2Len]; 
        // Getting the input list1 array
        for(int i=0; i<list1Len; i++){
            list1Arr[i] = Integer.parseInt(br.readLine());
        }
        //Getting the input list2 array
        for(int i=0;  i<list2Len; i++){
            list2Arr[i] = Integer.parseInt(br.readLine());
        }
        //Forming the linkedList1
        ListNode l1=null, l2=null, last1 =null, last2 = null;
        for(int i=0;i<list1Len;i++){
            ListNode temp = new ListNode(list1Arr[i]);
            if(l1 == null){
                l1 = last1 =temp;
            }else{
                last1.next = temp;
                last1 = temp;
            }
        }
        display(l1);
        // Forming the linkedList2
        for(int i=0;i<list2Len;i++){
            ListNode temp = new ListNode(list2Arr[i]);
            if(l2 == null){
                l2 = last2 = temp;
            }else{
                last2.next = temp;
                last2 = temp;
            }
        }
        display(l2);
        // Summing the numbers present in the linked lists
        ListNode resultList = addTwoNumbers(l1, l2);
        display(resultList);
    }
}