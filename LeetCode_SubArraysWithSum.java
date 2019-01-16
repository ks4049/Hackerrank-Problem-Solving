class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int sum,count=0;
        for(int i=0;i<A.length;i++){
            sum=0;
            for(int k=i;k<A.length;k++){
                if(A[k]){
                    sum++;
                }
                if(sum == S){
                    count++;
                }
            }
        }
        return count;   
    }
}