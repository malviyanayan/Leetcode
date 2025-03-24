import java.util.Arrays;

class Leetcode1051 {
    public static void main(String[] args) {
        
    }
    
    // this is counting sort question

    // with counting sort
    public int heightChecker(int[] heights) {
        int count = 0;
        
        // sorted heights
        int max = 0;
        for(int next : heights){
            if(next > max)max = next;
        }

        // count array
        int[] temp = new int[max+1];

        for(int i=0;i<heights.length;i++){
            temp[heights[i]]++;
        }

        // sorted heights array
        int[] sorted = new int[heights.length];
        int k = 0;
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i];j++){
                sorted[k++] = temp[i];
            }
        }

        for(int i=0;i<heights.length;i++){
            if(heights[i] != sorted[i])count++;
        }

        return count;
    }


    // without counting sort
    public int heightChecker1(int[] heights) {
        int count=0;
        int[] temp = new int[heights.length];

        for(int i=0;i<heights.length;i++){
            temp[i] = heights[i];
        }

        Arrays.sort(temp);

        for(int i=0;i<heights.length;i++){
            if(temp[i] != heights[i])count++;
        }

        return count;
    }
}
