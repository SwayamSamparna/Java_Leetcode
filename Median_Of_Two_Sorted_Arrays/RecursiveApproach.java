//TC: O(log(m+n)) SC: O(log(m+n)) Theoretical Optimal
public class RecursiveApproach {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int total = nums1.length + nums2.length;
        if(total % 2 == 1){
            return findKth(nums1, 0, nums2, 0, total/2+1);
        } else{
            return (findKth(nums1, 0, nums2, 0, total/2) + findKth(nums1, 0, nums2, 0, total/2+1))/2.0;
        }
    }

    public static int findKth(int[] A, int aStart, int[] B, int bStart, int k){
        if(aStart >= A.length) return B[bStart + k - 1];
        if(bStart >= B.length) return A[aStart + k - 1];
        if(k==1) return Math.min(A[aStart], B[bStart]);
        int aMid = (aStart + k / 2 - 1 < A.length) ? A[aStart + k / 2 - 1] : Integer.MAX_VALUE;
        int bMid = (bStart + k / 2 - 1 < B.length) ? B[bStart + k / 2 - 1] : Integer.MAX_VALUE;

        if(aMid < bMid){
            return findKth(A, aStart + k / 2, B, bStart, k - k / 2);
        }else{
            return findKth(A, aStart, B, bStart + k / 2, k - k / 2);
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }
}
