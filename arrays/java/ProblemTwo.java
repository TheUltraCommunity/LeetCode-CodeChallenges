import java.util.*;
public class ProblemTwo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 4, 45, 99, 45}; // Example array
        int secondLargest = findSecondLargestDistinctElement(arr);
        if (secondLargest != -1) {
            System.out.println("The second largest distinct element in the array is: " + secondLargest);
        } else {
            System.out.println("The second largest distinct element doesn't exist.");
        }
    }

    public static int findSecondLargestDistinctElement(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; // No second largest distinct element
        }
        
        Arrays.sort(arr);
        
        int largest = arr[arr.length - 1];
        int secondLargest = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                secondLargest = arr[i];
                break;
            }
        }

        return secondLargest;
    }
}
