class Leetcode2094{
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : digits)map.put(i,map.getOrDefault(i, 0) + 1);

        for(int i=100;i<999;i=i+2){
            int x = i;

            int c = x%10;x/=10;
            int b = x%10;x/=10;
            int a = x%10;x/=10;
            if(map.containsKey(a)){
                int aFreq = map.get(a);
                map.put(a, aFreq-1);
                if(aFreq==1)map.remove(a);

                if(map.containsKey(b)){
                    int bFreq = map.get(b);
                    map.put(b, bFreq-1);
                    if(bFreq == 1)map.remove(b);

                    if(map.containsKey(c)){
                        ans.add(i);
                    }

                    map.put(b, bFreq);
                }

                map.put(a, aFreq);
            }
        }

        int[] ans1 = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ans1[i] = ans.get(i);
        }

        return ans1;
    }

    public static void main(String[] args) {
        Leetcode2094 obj = new Leetcode2094();
        int[] digits = {2, 1, 3, 0};
        int[] result = obj.findEvenNumbers(digits);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}