import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Test1 {
    public static void main(String[] args) throws Exception{
        File inputs = new File("./TextFiles/Test1.txt");
	PrintWriter inputWrite = new PrintWriter(inputs);
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String first = scan.next();
            float second = scan.nextFloat();
	    float third = scan.nextFloat();
	    inputWrite.printf("%s %f %f\n", first, second, third);
	}
	scan.close();
	inputWrite.close();
	System.out.printf("\n");
	Scanner reader = new Scanner(inputs);
	while (reader.hasNextLine()) {
	    String first = reader.next();
	    float second = reader.nextFloat();
	    float third = reader.nextFloat();
            System.out.printf("%s %f %f\n", first, second, third);
	}
	reader.close();
    }
}
