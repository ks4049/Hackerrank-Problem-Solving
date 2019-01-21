class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(target - nums[i]) && (i != hashMap.get(target-nums[i]))){
                result[0] = hashMap.get(target-nums[i]);
                result[1] = i;
                break;
            }
            hashMap.put(nums[i],i);
        }
        return result;
    }
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for(int i =0; i<n ;i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        int target = Integer.parseInt(br.readLine());
        int[] result = new int[2];
        result = twoSum(nums, target);
        System.out.println("["+result[0]+","+result[1]"]");
    }
}