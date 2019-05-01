package LeetCode;

public class BSTRotatedArray {
    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr.length;

        int pivot = findPivot(arr, 0, n);
        
        bst();

        System.out.println(pivot);
    }

    private static void bst() {
    }

    private static int findPivot(int[] arr, int low, int high) {


        if (high < low) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (mid < high && arr[mid] > arr[mid + 1]) {
            return arr[mid];
        }

        if (mid > low && arr[mid] < arr[mid - 1]) {
            return arr[mid - 1];
        }

        if (arr[mid] > arr[low]) {
            return findPivot(arr, mid + 1, high);
        } else {
            return findPivot(arr, low, mid - 1);
        }

    }
    
    

}
