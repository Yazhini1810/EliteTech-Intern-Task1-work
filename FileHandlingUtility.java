package FileHandling;
  import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // Method to write data into a file
    public static void writeToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("✅ File written successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read data from a file
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("📖 File Contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Method to append data to an existing file (modification)
    public static void modifyFile(String fileName, String newData) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\n" + newData);
            System.out.println("✏ Data appended successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "sample.txt";

        System.out.println("=== FILE HANDLING UTILITY ===");
        System.out.println("1. Write to File");
        System.out.println("2. Read from File");
        System.out.println("3. Modify (Append) File");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter text to write: ");
                String writeData = sc.nextLine();
                writeToFile(fileName, writeData);
                break;

            case 2:
                readFromFile(fileName);
                break;

            case 3:
                System.out.print("Enter text to append: ");
                String appendData = sc.nextLine();
                modifyFile(fileName, appendData);
                break;

            default:
                System.out.println("Invalid choice! Please try again.");
        }

        sc.close();
    }
}