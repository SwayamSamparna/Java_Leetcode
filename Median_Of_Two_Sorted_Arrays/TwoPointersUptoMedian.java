//TC: O(log(M+N)) SC: O(1) (No merge) Saves Space
public class TwoPointersUptoMedian {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length;
        int total = m+n;
        int i=0, j=0, count=0;
        int a=0, b=0;

        while(count <= total / 2){
            a=b;
            if(i<m && (j>=n || nums1[i] < nums2[j])){
                b = nums1[i++];
            } else{
                b = nums2[j++];
            }
            count++;
        }
        if(total%2 == 1) return b;
        return (a+b) / 2.0;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }
}
