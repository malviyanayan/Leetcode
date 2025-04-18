class Leetcode38 {


    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");

        for(int i=2;i<=n;i++){
            int count = 1;
            int temp = sb.charAt(0);
            sb.deleteCharAt(0);
            int x = 0;
            while(x <= sb.length() ){
                if(x == sb.length() || temp != sb.charAt(x)){
                    sb.insert(x, temp);
                    sb.insert(x, count);
                    x+=2;
                    count = 1;
                    if(x < sb.length()){
                        temp = sb.charAt(x);
                        sb.deleteCharAt(x);
                    } 
                }else if(sb.charAt(x) == temp){
                        count++;
                        sb.deleteCharAt(x);
                }
            }
        }

        return sb.toString();
    }    
}
