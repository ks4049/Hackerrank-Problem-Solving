class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
         char[] str = s.toCharArray();
        int maxLen=0;
        for(int start=0 ; start<str.length; start++){
            List<Character> charList = new ArrayList<Character>();
            for(int i=start;i<str.length; i++){
                if(!charList.contains(str[i])){
                    charList.add(str[i]);
                }else{
                    break;
                }
            }
            int len = charList.size();
            if(maxLen < len){
                maxLen = len;
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        // Read the string
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = lengthOfLongestSubstring(input);
        System.out.println("The longest sub string length is "+length);
    }
}