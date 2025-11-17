import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
	File file1 = new File("firstNum.txt");
	File file2 = new File("secondNum.txt");
	PrintWriter write1 = new PrintWriter(file1);
	PrintWriter write2 = new PrintWriter(file2);
	write1.printf("%f", 5.0f);
	write2.printf("%f", 5.0f);
	write1.close();
	write2.close();
	p("firstNum.txt", "secondNum.txt", "productFile.txt");
    }
    public static void p(String file1, String file2, String newFile) throws Exception {
	PrintWriter productWriter = new PrintWriter(new File(newFile));
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
