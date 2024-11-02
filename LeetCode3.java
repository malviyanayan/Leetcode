class LeetCode3 {
    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "bbbbb";
        // String s = "pwwkew";
        String s = "aab";

        System.out.println("Lenght of longest Commont Substring : " + lengthOfLongestSubstring(s));
    }   
    
    static int lengthOfLongestSubstring(String s) {
        String temp = "";
        String subStr = "";
        int start = 0,end = 0;

        for(end = 0 ;end < s.length();end++){
            if(!subStr.contains("" + s.charAt(end))){
                subStr += s.charAt(end);
            }else{
                if(temp.length() < subStr.length())temp = subStr;
                start = start + 1;
                end = start;
                subStr = "" + s.charAt(end);
            }
        }

        if(subStr.length()>temp.length())return subStr.length();
        return temp.length(); 
    }
}
