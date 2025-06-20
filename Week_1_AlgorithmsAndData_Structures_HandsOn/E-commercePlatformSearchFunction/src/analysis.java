
public class analysis {



    // Linear Search Function
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // Best Case: Key is at the beginning
        long startBest = System.nanoTime();
        linearSearch(arr, 0);
        long endBest = System.nanoTime();

        // Average Case: Key is in the middle
        long startAvg = System.nanoTime();
        linearSearch(arr, arr.length / 2);
        long endAvg = System.nanoTime();

        // Worst Case: Key is at the end or not found
        long startWorst = System.nanoTime();
        linearSearch(arr, arr.length - 1);
        long endWorst = System.nanoTime();

        System.out.println("Best Case Time (ns): " + (endBest - startBest));
        System.out.println("Average Case Time (ns): " + (endAvg - startAvg));
        System.out.println("Worst Case Time (ns): " + (endWorst - startWorst));
    }
}
