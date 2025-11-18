import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        // Test Case
        Scanner userInput = new Scanner(System.in);
        File file1 = new File("firstNum.txt");
        File file2 = new File("secondNum.txt");
        PrintWriter write1 = new PrintWriter(file1);
        PrintWriter write2 = new PrintWriter(file2);
        System.out.println("Enter a factor for multiplication: ");
        float num1 = userInput.nextFloat();
        System.out.println("Enter another factor to multiply: ");
        float num2 = userInput.nextFloat();
        write1.printf("%f", num1);
        write2.printf("%f", num2);
        write1.close();
        write2.close();
        userInput.close();
        p("firstNum.txt", "secondNum.txt", "productFile.txt");
    }
    public static void p(String file1, String file2, String newFile) throws Exception {
        PrintWriter productWriter = new PrintWriter(new File(newFile));
	// First argument grabs directory, second argument searches file name
        File firstFile = new File("./", file1);
        File secondFile = new File("./", file2);
        Scanner scanFirst = new Scanner(firstFile);
        Scanner scanSecond = new Scanner(secondFile);
        float firstInput = 0.0f, secondInput = 0.0f;
        while (scanFirst.hasNextFloat() && scanSecond.hasNextFloat()) {
            firstInput = scanFirst.nextFloat();
            secondInput = scanSecond.nextFloat();
        }
        productWriter.printf("%f", firstInput * secondInput);
        scanFirst.close();
        scanSecond.close();
        productWriter.close();
    }
}
