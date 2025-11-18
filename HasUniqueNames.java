import java.util.Scanner;
import java.io.File;

public class HasUniqueNames {
    public static void main(String[] args) throws Exception {
        File test = new File("./TextFiles/Test1.txt");
	Scanner scanTest = new Scanner(test);
	String names[] = new String[100];
	double tripAverages[] = new double[100];
	int index = 0;
	while (scanTest.hasNext()) {
            String name = scanTest.next();
	    float firstNum = scanTest.nextFloat();
	    float secondNum = scanTest.nextFloat();
	    double avg = (firstNum + secondNum) / 2;
            names[index] = name;
            tripAverages[index] = avg;
	    index += 1;
	}
	boolean uniqueNames = true;
	for (int i = 0; i < names.length - 1; i++){
            String name1 = names[i];
	    for (int j = i + 1; j < names.length; j++) {
                String name2 = names[j];
		if (name1.equals(name2)) uniqueNames = false;
	    }
	}
	System.out.printf("\n%b\n", uniqueNames);
    }
}
