public class problem_1 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 4, 45, 99, 6}; // Example array
        int largest = findLargestElement(arr);
        System.out.println("The largest element in the array is: " + largest);
    }

    public static int findLargestElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
