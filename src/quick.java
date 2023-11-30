import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class quick {
    public static void main(String[] args) {
        String filePath = "random_numbers.txt";
        int[] arr = readNumbersFromFile(filePath);
        long startTime = System.currentTimeMillis();

        if (arr != null) {
            System.out.println("Original Array:");
            printArray(arr);
            quickSort(arr, 0, arr.length - 1);
            System.out.println("\nSorted Array:");
            printArray(arr);
        } else {
            System.out.println("Error reading numbers from file.");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime) + " milliseconds");
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] readNumbersFromFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            int count = 0;

            while (line != null) {
                count++;
                line = reader.readLine();
            }

            int[] arr = new int[count];

            reader.close();
            reader = new BufferedReader(new FileReader(filePath));

            for (int i = 0; i < count; i++) {
                line = reader.readLine();
                arr[i] = Integer.parseInt(line);
            }

            reader.close();
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
