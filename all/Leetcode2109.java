// 2109. Adding Spaces to a String

class Leetcode2109 {
    public static void main(String[] args) {
        
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;

        for(int i=0;i<s.length();i++){
            if(idx < spaces.length && i == spaces[idx]){
                sb.append(" " + s.charAt(i));
                idx++;
            }else{
                sb.append(s.charAt(i));
            }
        }

        return new String(sb);
    }
}
