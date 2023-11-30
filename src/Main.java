import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Enter the amount of numbers to be generated");
        int x = in.nextInt();
        String filePath = "random_numbers.txt";
        generateAndWriteRandomNumbers(x, filePath);
        System.out.println("Random numbers generated and saved to " + filePath);
    }
    public static void generateAndWriteRandomNumbers(int x, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();

            for (int i = 0; i < x; i++) {
                int randomNumber = random.nextInt(x + 1);
                writer.write(Integer.toString(randomNumber));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
