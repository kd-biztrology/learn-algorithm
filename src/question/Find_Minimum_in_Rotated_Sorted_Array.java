package question;

/**
 * Created by kevin on 16/4/13. <p> Suppose a sorted array is rotated at some pivot unknown to you
 * beforehand. <p> (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). <p>
 */
public class Find_Minimum_in_Rotated_Sorted_Array {

    private static final int datas[] = { 1 };

    public static void main(String[] args) {
        findMain(datas);
    }

    private static int findMain(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[end] < nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(Math.min(nums[start],nums[end]));
        return Math.min(nums[start],nums[end]);
    }
}
