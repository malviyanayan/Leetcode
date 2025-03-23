class Leetcode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        m = m-1;
        n = n-1;

        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]){
                nums1[last--] = nums1[m--];
            }else{
                nums1[last--] = nums2[n--];
            }
        }

        while(m >= 0){
            nums1[last--] = nums1[m--];
        }

        while (n >= 0) {
            nums1[last--] = nums2[n--];
        }
    }

    public static void main(String[] args){

    }    
}
